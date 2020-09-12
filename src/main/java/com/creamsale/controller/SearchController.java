package com.creamsale.controller;

import com.creamsale.payload.product_offer.ProductOfferResponse;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/product/{productName}")
    public List<ProductOfferResponse> findProductOffers(@PathVariable final String productName) {
        //ToDo validate productName

        return searchService.findProductOffers(productName);
    }

}
