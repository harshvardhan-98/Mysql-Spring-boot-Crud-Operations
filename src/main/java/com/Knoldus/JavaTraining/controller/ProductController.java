package com.Knoldus.JavaTraining.controller;

import com.Knoldus.JavaTraining.service.ProductService;
import com.Knoldus.JavaTraining.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Add product product.
     *
     * @param product the product
     * @return the product
     */
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    /**
     * Add products list.
     *
     * @param products the products
     * @return the list
     */
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    /**
     * Find all products list.
     *
     * @return the list
     */
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    /**
     * Find product by id product.
     *
     * @param id the id
     * @return the product
     */
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    /**
     * Find product by name product.
     *
     * @param name the name
     * @return the product
     */
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    /**
     * Update product product.
     *
     * @param product the product
     * @return the product
     */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    /**
     * Delete product string.
     *
     * @param id the id
     * @return the string
     */
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
