package com.creamsale.controller;

import com.creamsale.domain.CashBackSale;
import com.creamsale.payload.ApiResponse;
import com.creamsale.payload.cashback.CashBackSaleRequest;
import com.creamsale.payload.cashback.CashBackSaleResponse;
import com.creamsale.service.CashBackSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cashback-sales")
public class CashBackSaleController {

    private final CashBackSaleService cashBackSaleService;

    @Autowired
    public CashBackSaleController(CashBackSaleService cashBackSaleService) {
        this.cashBackSaleService = cashBackSaleService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCashBackSale(@Valid @RequestBody final CashBackSaleRequest cashBackSaleRequest) {

        CashBackSale createdCashBackSale = cashBackSaleService.createCashBackSale(cashBackSaleRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{cashBackSaleId}")
                .buildAndExpand(createdCashBackSale.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "CashBackSale has been created successfully"));
    }

    @GetMapping("/all")
    public List<CashBackSaleResponse> findAllCashBackSales() {
        return cashBackSaleService.findAllCashBackSales();
    }

    @GetMapping("/sale/id/{cashBackSaleId}")
    public CashBackSaleResponse findCashBackSaleById(@PathVariable final Long cashBackSaleId) {
        return cashBackSaleService.findCashBackSaleById(cashBackSaleId);
    }
}
