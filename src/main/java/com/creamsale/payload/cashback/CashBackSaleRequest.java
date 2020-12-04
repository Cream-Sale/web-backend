package com.creamsale.payload.cashback;

import java.math.BigDecimal;

public class CashBackSaleRequest {

    private final Long cashBackId;
    private final Long shopId;
    private final BigDecimal sale;
    private final String description;

    public CashBackSaleRequest(Long cashBackId, Long shopId, BigDecimal sale, String description) {
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

    public BigDecimal getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }
}
