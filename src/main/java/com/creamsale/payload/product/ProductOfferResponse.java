package com.creamsale.payload.product;

import com.creamsale.payload.cashback.CashBackSaleResponse;

public class ProductOfferResponse {

    private final ProductResponse productResponse;
    private final CashBackSaleResponse cashBackSaleResponse;

    public ProductOfferResponse(ProductResponse productResponse, CashBackSaleResponse cashBackSaleResponse) {
        this.productResponse = productResponse;
        this.cashBackSaleResponse = cashBackSaleResponse;
    }

    public ProductResponse getProductResponse() {
        return productResponse;
    }

    public CashBackSaleResponse getCashBackSaleResponse() {
        return cashBackSaleResponse;
    }
}
