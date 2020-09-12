package com.creamsale.service;

import com.creamsale.domain.Shop;
import com.creamsale.payload.shop.ShopRequest;
import com.creamsale.payload.shop.ShopResponse;
import com.creamsale.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createShop(final ShopRequest shopRequest) {
        Shop shop = toShopModel(shopRequest);
        return shopRepository.save(shop);
    }

    public List<ShopResponse> findAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return toShopResponseList(shops);
    }

    public ShopResponse findShopById(final Long shopId) {
        Shop shop = shopRepository.findShopById(shopId);
        return toShopResponse(shop);
    }

    public ShopResponse findShopByName(final String shopName) {
        Shop shop = shopRepository.findShopByName(shopName);
        return toShopResponse(shop);
    }


    private Shop toShopModel(final ShopRequest shopRequest) {
        Shop shop = new Shop();
        shop.setName(shopRequest.getName());
        shop.setLink(shopRequest.getLink());
        shop.setImgLink(shopRequest.getImgLink());

        return shop;
    }

    private ShopResponse toShopResponse(final Shop shop) {
        return new ShopResponse(shop.getId(), shop.getName(), shop.getLink(), shop.getImgLink());
    }

    private List<ShopResponse> toShopResponseList(final List<Shop> shops) {
        List<ShopResponse> shopResponses = new LinkedList<>();
        shops.forEach(shop -> shopResponses.add(toShopResponse(shop)));
        return shopResponses;
    }
}
