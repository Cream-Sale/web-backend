package com.creamsale.payload.cashback;

import com.creamsale.domain.CashBack;
import com.creamsale.domain.Shop;

public class CashBackSaleResponse {

    private final Long id;
    private final CashBack cashBack;
    private final Shop shop;
    private final Float sale;
    private final String description;

    public CashBackSaleResponse(Long id, CashBack cashBack, Shop shop, Float sale, String description) {
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

    public Float getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }
}
