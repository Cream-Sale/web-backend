package com.creamsale.repository.specifications;

import com.creamsale.domain.Product;
import com.creamsale.domain.Product_;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;

public class ProductSpecifications {

    public static Specification<Product> likeProductName(String partOfProductName) {
        if (Objects.isNull(partOfProductName)) {
            return null;
        }
        return ((root, query, cb) -> cb.like(root.get(Product_.FULL_NAME), "%" + partOfProductName + "%"));
    }

    public static Specification<Product> inClauseShops(List<Long> shops) {
        if (Objects.isNull(shops) || shops.isEmpty()) {
            return null;
        }
        return (root, query, cb) -> root.get(Product_.SHOP_ID).in(shops);
    }

    public static Specification<Product> betweenPrice(Float priceFrom, Float priceTo) {
        if (Objects.isNull(priceFrom) && Objects.isNull(priceTo)) {
            return null;
        } else if (Objects.isNull(priceFrom)) {
            return ((root, query, cb) -> cb.lessThanOrEqualTo(root.get(Product_.PRICE), priceTo));
        } else if (Objects.isNull(priceTo)) {
            return ((root, query, cb) -> cb.greaterThanOrEqualTo(root.get(Product_.PRICE), priceFrom));
        }

        return ((root, query, cb) -> cb.between(root.get(Product_.PRICE), priceFrom, priceTo));
    }
}
