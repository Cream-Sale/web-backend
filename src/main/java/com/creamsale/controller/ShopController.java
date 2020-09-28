package com.creamsale.controller;

import com.creamsale.domain.Shop;
import com.creamsale.payload.ApiResponse;
import com.creamsale.payload.shop.ShopRequest;
import com.creamsale.payload.shop.ShopResponse;
import com.creamsale.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShop(@Valid @RequestBody final ShopRequest shopRequest) {

        Shop createdShop = shopService.createShop(shopRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{shopId}")
                .buildAndExpand(createdShop.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Shop has been created successfully"));
    }

    @GetMapping("/all")
    public List<ShopResponse> findAllShops() {
        return shopService.findAllShops();
    }

    @GetMapping("/shop/id/{shopId}")
    public ShopResponse findShopById(@PathVariable final Long shopId) {
        return shopService.findShopById(shopId);
    }

    @GetMapping("/shop/name/{shopName}")
    public ShopResponse findShopByName(@PathVariable final String shopName) {
        return shopService.findShopByName(shopName);
    }

}
