package com.creamsale.controller;

import com.creamsale.payload.product.ProductOffer;
import com.creamsale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product")
    public List<ProductOffer> findProductOffers(@RequestParam(value = "search") final String search) {
        if (Objects.isNull(search) || search.equals("")) {
            return null; //ToDo
        }

        return searchService.findProductOffers(search);
    }

}
