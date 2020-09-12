package com.creamsale.payload.product;

import com.creamsale.domain.CashBack;
import com.creamsale.domain.CashBackSale;
import com.creamsale.domain.Product;
import com.creamsale.domain.Shop;

public class ProductOfferResponse {

    private final Product product;
    private final CashBackSale cashBackSale;
    private final CashBack cashBack;
    private final Shop shop;

    public ProductOfferResponse(Product product, CashBackSale cashBackSale, CashBack cashBack, Shop shop) {
        this.product = product;
        this.cashBackSale = cashBackSale;
        this.cashBack = cashBack;
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public CashBackSale getCashBackSale() {
        return cashBackSale;
    }

    public CashBack getCashBack() {
        return cashBack;
    }

    public Shop getShop() {
        return shop;
    }
}
