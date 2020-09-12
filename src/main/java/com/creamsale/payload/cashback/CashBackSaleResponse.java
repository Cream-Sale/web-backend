package com.creamsale.payload.cashback;

import com.creamsale.domain.CashBack;
import com.creamsale.domain.Shop;

public class CashBackSaleResponse {

    private final Long id;
    private final CashBack cashBack;
    private final Shop shop;
    private final Integer sale;
    private final String description;

    public CashBackSaleResponse(Long id, CashBack cashBack, Shop shop, Integer sale, String description) {
        this.id = id;
        this.cashBack = cashBack;
        this.shop = shop;
        this.sale = sale;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public CashBack getCashBack() {
        return cashBack;
    }

    public Shop getShop() {
        return shop;
    }

    public Integer getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }
}
