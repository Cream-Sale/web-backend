package com.creamsale.controller;

import com.creamsale.domain.CashBack;
import com.creamsale.payload.ApiResponse;
import com.creamsale.payload.cashback.CashBackRequest;
import com.creamsale.payload.cashback.CashBackResponse;
import com.creamsale.service.CashBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cashbacks")
public class CashBackController {

    private final CashBackService cashBackService;

    @Autowired
    public CashBackController(CashBackService cashBackService) {
        this.cashBackService = cashBackService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCashBack(@Valid @RequestBody final CashBackRequest cashBackRequest) {

        CashBack createdShop = cashBackService.createCashBack(cashBackRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{cashBackId}")
                .buildAndExpand(createdShop.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Shop has been created successfully"));
    }

    @GetMapping("/all")
    public List<CashBackResponse> findAllCashBacks() {
        return cashBackService.findAllCashBacks();
    }

    @GetMapping("/cashback/id/{cashBackId}")
    public CashBackResponse findCashBackById(@PathVariable final Long cashBackId) {
        return cashBackService.findCashBackById(cashBackId);
    }

    @GetMapping("/cashback/name/{cashBackName}")
    public CashBackResponse findCashBackByName(@PathVariable final String cashBackName) {
        return cashBackService.findCashBackByName(cashBackName);
    }

}
