package com.creamsale.service.mapper;

import com.creamsale.domain.Shop;
import com.creamsale.payload.shop.ShopRequest;
import com.creamsale.payload.shop.ShopResponse;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ShopMapper {

    public Shop toShopModel(final ShopRequest shopRequest) {
        Shop shop = new Shop();
        shop.setName(shopRequest.getName());
        shop.setLink(shopRequest.getLink());
        shop.setImgLink(shopRequest.getImgLink());

        return shop;
    }

    public ShopResponse toShopResponse(final Shop shop) {
        return new ShopResponse(shop.getId(), shop.getName(), shop.getLink(), shop.getImgLink());
    }

    public List<ShopResponse> toShopResponseList(final List<Shop> shops) {
        List<ShopResponse> shopResponses = new LinkedList<>();
        shops.forEach(shop -> shopResponses.add(toShopResponse(shop)));
        return shopResponses;
    }

}
