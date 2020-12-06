package com.creamsale.service;

import com.creamsale.domain.CashBackSale;
import com.creamsale.exception.NotFoundException;
import com.creamsale.payload.cashback.CashBackSaleRequest;
import com.creamsale.payload.cashback.CashBackSaleResponse;
import com.creamsale.repository.CashBackSaleRepository;
import com.creamsale.service.mapper.CashBackSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CashBackSaleService {

    private final CashBackSaleRepository cashBackSaleRepository;

    private final CashBackSaleMapper cashBackSaleMapper;

    @Autowired
    public CashBackSaleService(CashBackSaleRepository cashBackSaleRepository, CashBackSaleMapper cashBackSaleMapper) {
        this.cashBackSaleRepository = cashBackSaleRepository;
        this.cashBackSaleMapper = cashBackSaleMapper;
    }

    public CashBackSale createCashBackSale(final CashBackSaleRequest cashBackSaleRequest) {
        CashBackSale cashBackSale = cashBackSaleMapper.toCashBackSaleModel(cashBackSaleRequest);
        return cashBackSaleRepository.save(cashBackSale);
    }

    public List<CashBackSaleResponse> findAllCashBackSales() {
        List<CashBackSale> cashBackSales = cashBackSaleRepository.findAll();
        return cashBackSaleMapper.toCashBackSaleResponseList(cashBackSales);
    }

    public CashBackSaleResponse findCashBackSaleById(final Long cashBackSaleId) {
        CashBackSale cashBackSale = cashBackSaleRepository.findCashBackSaleById(cashBackSaleId);
        if (Objects.isNull(cashBackSale)) {
            throw new NotFoundException(String.format("CashBackSale with '%s' id not found", cashBackSaleId));
        }
        return cashBackSaleMapper.toCashBackSaleResponse(cashBackSale);
    }

    public CashBackSaleResponse findCashBackSaleByShopId(final Long shopId) {
        CashBackSale cashBackSale = cashBackSaleRepository.findCashBackSaleByShopId(shopId);
        if (Objects.isNull(cashBackSale)) {
            throw new NotFoundException(String.format("CashBackSale with '%s' shopId not found", shopId));
        }
        return cashBackSaleMapper.toCashBackSaleResponse(cashBackSale);
    }

}
