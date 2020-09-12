package com.creamsale.service;

import com.creamsale.payload.cashback.CashBackSaleResponse;
import com.creamsale.payload.product.ProductOfferResponse;
import com.creamsale.payload.product.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ProductService productService;

    private final CashBackSaleService cashBackSaleService;

    @Autowired
    public SearchService(ProductService productService, CashBackSaleService cashBackSaleService) {
        this.productService = productService;
        this.cashBackSaleService = cashBackSaleService;
    }

    public List<ProductOfferResponse> findProductOffers(final String productName) {
        //ToDo optimize product search

        List<ProductResponse> productResponses = productService.findProductsByName(productName);
        List<ProductOfferResponse> productOfferResponses = productResponses.stream()
                .filter(Objects::nonNull)
                .map(productResponse -> {
                    CashBackSaleResponse cashBackSaleResponse = cashBackSaleService.findCashBackSaleByShopId(productResponse.getShopId());
                    return new ProductOfferResponse(productResponse, cashBackSaleResponse);
                })
                .collect(Collectors.toList());
        return productOfferResponses;
    }




}
