package com.creamsale.controller;

import com.creamsale.domain.Product;
import com.creamsale.payload.ApiResponse;
import com.creamsale.payload.product.ProductRequest;
import com.creamsale.payload.product.ProductResponse;
import com.creamsale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody final ProductRequest productRequest) {

        Product createdProduct = productService.createProduct(productRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{productId}")
                .buildAndExpand(createdProduct.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Product has been created successfully"));
    }

    @GetMapping("/all")
    public List<ProductResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/product/id/{productId}")
    public ProductResponse findProductById(@PathVariable final Long productId) {
        return productService.findProductById(productId);
    }

    @GetMapping("/product/name/{productName}")
    public List<ProductResponse> findProductsByName(@PathVariable final String productName) {
        return productService.findProductsByName(productName);
    }

}
