package com.creamsale.repository;

import com.creamsale.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Long id);

    Product findProductByName(String name);

}
