package com.Knoldus.JavaTraining.repository;

import com.Knoldus.JavaTraining.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {

    /**
     * Find by name product.
     *
     * @param name the name
     * @return the product
     */
    Product findByName(String name);
}

