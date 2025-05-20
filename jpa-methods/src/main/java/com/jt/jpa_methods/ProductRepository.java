package com.jt.jpa_methods;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductName(String productName);

    List<Product> findAllByProductPriceBetween(double price1, double price2);
    
    List<Product> findAllByProductPriceGreaterThan(double price, Sort sort);

    Optional<Product> findByProductPriceAndProductBrand(double price, String productBrand);

    Optional<Product> findDistinctByProductName(String productName);

    Optional<Product> findByProductNameEquals(String productName);
    
    Optional<Product> findByProductNameStartingWith(String initialProductName);
    
    Optional<Product> findByProductNameContaining(String containedName);
    
    List<Product> findByProductBrandNot(String otherName);
}