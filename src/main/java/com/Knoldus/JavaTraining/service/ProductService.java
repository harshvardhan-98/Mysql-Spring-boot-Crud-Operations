package com.Knoldus.JavaTraining.service;

import com.Knoldus.JavaTraining.entity.Product;
import com.Knoldus.JavaTraining.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Save product product.
     *
     * @param product the product
     * @return the product
     */
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    /**
     * Save products list.
     *
     * @param products the products
     * @return the list
     */
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<Product> getProducts() {
        return repository.findAll();
    }

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Gets product by name.
     *
     * @param name the name
     * @return the product by name
     */
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Delete product string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    /**
     * Update product product.
     *
     * @param product the product
     * @return the product
     */
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
