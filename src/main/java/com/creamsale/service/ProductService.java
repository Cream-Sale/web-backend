package com.creamsale.service;

import com.creamsale.domain.Product;
import com.creamsale.payload.product.ProductRequest;
import com.creamsale.payload.product.ProductResponse;
import com.creamsale.repository.ProductRepository;
import com.creamsale.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product createProduct(final ProductRequest productRequest) {
        Product product = productMapper.toProductModel(productRequest);
        return productRepository.save(product);
    }

    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductResponseList(products);
    }

    public ProductResponse findProductById(final Long productId) {
        Product product = productRepository.findProductById(productId);
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findProductsByName(final String productName) {
        List<Product> products = productRepository.findProductsByName(productName);
        List<ProductResponse> productResponses = products.stream()
                .filter(Objects::nonNull)
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
        return productResponses;
    }

}
