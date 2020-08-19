package com.creamsale.service;

import com.creamsale.model.Shop;
import com.creamsale.payload.ShopRequest;
import com.creamsale.payload.ShopResponse;
import com.creamsale.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createShop(ShopRequest shopRequest) {
        Shop shop = toShopModel(shopRequest);
        return shopRepository.save(shop);
    }

    public List<ShopResponse> findAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return toShopResponseList(shops);
    }


    private Shop toShopModel(ShopRequest shopRequest) {
        Shop shop = new Shop();
        shop.setName(shopRequest.getName());
        shop.setLink(shopRequest.getLink());
        shop.setImgLink(shopRequest.getImgLink());

        return shop;
    }

    private ShopResponse toShopResponse(Shop shop) {
        return new ShopResponse(shop.getId(), shop.getName(), shop.getLink(), shop.getImgLink());
    }

    private List<ShopResponse> toShopResponseList(List<Shop> shops) {
        List<ShopResponse> shopResponses = new LinkedList<>();
        shops.forEach(shop -> shopResponses.add(toShopResponse(shop)));
        return shopResponses;
    }
}
