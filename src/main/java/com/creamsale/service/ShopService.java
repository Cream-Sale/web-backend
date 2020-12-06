package com.creamsale.service;

import com.creamsale.domain.Shop;
import com.creamsale.exception.NotFoundException;
import com.creamsale.payload.shop.ShopRequest;
import com.creamsale.payload.shop.ShopResponse;
import com.creamsale.repository.ShopRepository;
import com.creamsale.service.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    private final ShopMapper shopMapper;

    @Autowired
    public ShopService(ShopRepository shopRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.shopMapper = shopMapper;
    }

    public Shop createShop(final ShopRequest shopRequest) {
        Shop shop = shopMapper.toShopModel(shopRequest);
        return shopRepository.save(shop);
    }

    public List<ShopResponse> findAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return shopMapper.toShopResponseList(shops);
    }

    public ShopResponse findShopById(final Long shopId) {
        Shop shop = shopRepository.findShopById(shopId);
        if (Objects.isNull(shop)) {
            throw new NotFoundException(String.format("Shop with '%s' id not found", shopId));
        }
        return shopMapper.toShopResponse(shop);
    }

    public ShopResponse findShopByName(final String shopName) {
        Shop shop = shopRepository.findShopByName(shopName);
        if (Objects.isNull(shop)) {
            throw new NotFoundException(String.format("Shop with '%s' name not found", shopName));
        }
        return shopMapper.toShopResponse(shop);
    }

    public boolean existsByShopName(final String shopName) {
        return shopRepository.existsByName(shopName);
    }

    public boolean existsByShopId(final Long shopId) {
        return shopRepository.existsById(shopId);
    }
}
