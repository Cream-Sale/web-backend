package com.creamsale.controller;

import com.creamsale.payload.product.ProductOfferResponse;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/product")
    public List<ProductOfferResponse> findProductOffers(@RequestParam(value = "search") final String productName) {
        if (Objects.isNull(productName) || productName.equals("")) {
            return null; //ToDo
        }

        return searchService.findProductOffers(productName);
    }

}
