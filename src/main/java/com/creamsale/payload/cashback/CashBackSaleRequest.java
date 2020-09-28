package com.creamsale.payload.cashback;

public class CashBackSaleRequest {

    private final Long cashBackId;
    private final Long shopId;
    private final Float sale;
    private final String description;

    public CashBackSaleRequest(Long cashBackId, Long shopId, Float sale, String description) {
        this.cashBackId = cashBackId;
        this.shopId = shopId;
        this.sale = sale;
        this.description = description;
    }

    public Long getCashBackId() {
        return cashBackId;
    }

    public Long getShopId() {
        return shopId;
    }

    public Float getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }
}
