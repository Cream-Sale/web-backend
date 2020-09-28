package com.creamsale.service.mapper;

import com.creamsale.domain.CashBackSale;
import com.creamsale.payload.cashback.CashBackSaleRequest;
import com.creamsale.payload.cashback.CashBackSaleResponse;
import com.creamsale.repository.CashBackRepository;
import com.creamsale.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CashBackSaleMapper {

    private final CashBackRepository cashBackRepository;

    private final ShopRepository shopRepository;

    @Autowired
    public CashBackSaleMapper(CashBackRepository cashBackRepository, ShopRepository shopRepository) {
        this.cashBackRepository = cashBackRepository;
        this.shopRepository = shopRepository;
    }

    public CashBackSale toCashBackSaleModel(final CashBackSaleRequest cashBackSaleRequest) {
        if (Objects.isNull(cashBackSaleRequest)) {
            return null;
        }
        CashBackSale cashBackSale = new CashBackSale();
        cashBackSale.setCashBack(cashBackRepository.findCashBackById(cashBackSaleRequest.getCashBackId()));
        cashBackSale.setDescription(cashBackSaleRequest.getDescription());
        cashBackSale.setSale(cashBackSaleRequest.getSale());
        cashBackSale.setShop(shopRepository.findShopById(cashBackSaleRequest.getShopId()));
        return cashBackSale;
    }

    public CashBackSaleResponse toCashBackSaleResponse(final CashBackSale cashBackSale) {
        if (Objects.isNull(cashBackSale)) {
            return null;
        }
        return new CashBackSaleResponse(cashBackSale.getId(), cashBackSale.getCashBack(), cashBackSale.getShop(),
                cashBackSale.getSale(), cashBackSale.getDescription());
    }

    public List<CashBackSaleResponse> toCashBackSaleResponseList(final List<CashBackSale> cashBackSales) {
        return cashBackSales.stream()
                .filter(Objects::nonNull)
                .map(this::toCashBackSaleResponse)
                .collect(Collectors.toList());
    }

}
