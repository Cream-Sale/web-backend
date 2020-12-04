package com.creamsale.payload.product;

import com.creamsale.domain.Currency;

import java.math.BigDecimal;


public class ProductRequest {

    private final String name;
    private final String fullName;
    private final Long shopId;
    private final BigDecimal price;
    private final Currency currency;
    private final String shopCategory;
    private final String imageLink;

    public ProductRequest(String name, String fullName, Long shopId, BigDecimal price, Currency currency, String shopCategory, String imageLink) {
        this.name = name;
        this.fullName = fullName;
        this.shopId = shopId;
        this.price = price;
        this.currency = currency;
        this.shopCategory = shopCategory;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Long getShopId() {
        return shopId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public String getImageLink() {
        return imageLink;
    }
}
