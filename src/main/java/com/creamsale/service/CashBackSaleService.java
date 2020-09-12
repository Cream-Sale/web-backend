package com.creamsale.service;

import com.creamsale.domain.CashBackSale;
import com.creamsale.domain.Shop;
import com.creamsale.payload.cashback.CashBackSaleRequest;
import com.creamsale.payload.cashback.CashBackSaleResponse;
import com.creamsale.repository.CashBackSaleRepository;
import com.creamsale.service.mapper.CashBackSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return cashBackSaleMapper.toCashBackSaleResponse(cashBackSale);
    }

    public CashBackSaleResponse findCashBackSaleByShop(final Shop shop) {
        CashBackSale cashBackSale = cashBackSaleRepository.findCashBackSaleByShop(shop);
        return cashBackSaleMapper.toCashBackSaleResponse(cashBackSale);
    }

}
