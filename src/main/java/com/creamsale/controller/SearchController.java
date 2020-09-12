package com.creamsale.controller;

import com.creamsale.payload.product.ProductOfferResponse;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @PostMapping("/product/{productName}")
    public List<ProductOfferResponse> findProductOffers(@Valid @PathVariable final String productName) {
        if (Objects.isNull(productName) || productName.equals("")) {
            return null; //ToDo
        }

        return searchService.findProductOffers(productName);
    }

}
