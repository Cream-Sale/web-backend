package com.creamsale.payload.product;

import com.creamsale.domain.Currency;

public class ProductResponse {

    private final Long id;
    private final String name;
    private final String fullName;
    private final Long shopId;
    private final Float price;
    private final Currency currency;
    private final String shopCategory;
    private final String imageLink;

    public ProductResponse(Long id, String name, String fullName, Long shopId, Float price, Currency currency, String shopCategory, String imageLink) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.shopId = shopId;
        this.price = price;
        this.currency = currency;
        this.shopCategory = shopCategory;
        this.imageLink = imageLink;
    }

    public Long getId() {
        return id;
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

    public Float getPrice() {
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
