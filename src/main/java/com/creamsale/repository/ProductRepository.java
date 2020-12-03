package com.creamsale.repository;

import com.creamsale.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Product findProductById(Long id);

    List<Product> findProductsByName(String name);

    @Query("FROM Product WHERE fullName LIKE %:partOfName%")
    List<Product> findProductByPartOfName(@Param("partOfName") String partOfName);

}
