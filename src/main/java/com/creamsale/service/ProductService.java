package com.creamsale.service;

import com.creamsale.domain.Product;
import com.creamsale.payload.product.ProductRequest;
import com.creamsale.payload.product.ProductResponse;
import com.creamsale.repository.ProductRepository;
import com.creamsale.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductResponse findProductByName(final String productName) {
        Product product = productRepository.findProductByName(productName);
        return productMapper.toProductResponse(product);
    }

}
