package com.creamsale.repository;

import com.creamsale.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Shop findShopById(Long id);

    Shop findShopByName(String name);

    boolean existsByName(String name);

    boolean existsById(Long id);
}
