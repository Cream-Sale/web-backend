package com.creamsale.service.mapper;

import com.creamsale.domain.Product;
import com.creamsale.payload.product.ProductRequest;
import com.creamsale.payload.product.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product toProductModel(final ProductRequest productRequest) {
        if (Objects.isNull(productRequest)) {
            return null;
        }
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setFullName(productRequest.getFullName());
        product.setImageLink(productRequest.getImageLink());
        product.setPrice(productRequest.getPrice());
        product.setCurrency(productRequest.getCurrency());
        product.setShopCategory(productRequest.getShopCategory());
        product.setShopId(productRequest.getShopId());
        return product;
    }

    public ProductResponse toProductResponse(final Product product) {
        if (Objects.isNull(product)) {
            return null;
        }
        return new ProductResponse(product.getId(), product.getName(), product.getFullName(), product.getShopId(),
                product.getPrice(), product.getCurrency(), product.getShopCategory(), product.getImageLink());
    }

    public List<ProductResponse> toProductResponseList(final List<Product> products) {
        return products.stream()
                .filter(Objects::nonNull)
                .map(this::toProductResponse)
                .collect(Collectors.toList());
    }

}
