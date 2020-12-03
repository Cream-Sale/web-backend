package com.creamsale.controller;

import com.creamsale.payload.product.ProductOffer;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/products")
    public List<ProductOffer> findProductOffers(@RequestParam(value = "search") final String search) {
        return searchService.findProductOffersByPartOfProductName(search);
    }

    @GetMapping("/productsByFilter")
    public List<ProductOffer> findProductsByParams(
            @RequestParam(name = "productName", required = false) final String partOfProductName,
            @RequestParam(name = "shops", required = false) final List<Long> shops,
            @RequestParam(name = "priceFrom", required = false) final Float priceFrom,
            @RequestParam(name = "priceTo", required = false) final Float priceTo) {

        return searchService.findProductOffersByPartOfProductNameAndShopsAndPriceRange(
                partOfProductName, shops, priceFrom, priceTo
        );
    }

}
