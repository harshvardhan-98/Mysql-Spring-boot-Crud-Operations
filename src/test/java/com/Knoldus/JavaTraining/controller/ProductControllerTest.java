package com.Knoldus.JavaTraining.controller;

import com.Knoldus.JavaTraining.entity.Product;
import com.Knoldus.JavaTraining.repository.ProductRepository;
import com.Knoldus.JavaTraining.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * The type Product controller test.
 */
@AutoConfigureMockMvc
@SpringBootTest()
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @MockBean
    private ProductController productController;
    private ProductRepository productRepository;

    /**
     * The Object mapper.
     */
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * The Product.
     */
    Product product= new Product(1,"Laptop",5,65000.00);

    /**
     * Should add the new product.
     *
     * @throws Exception the exception
     */
    @Test
    public void addProduct() throws Exception {
        BDDMockito.given(productService.saveProduct(product))
                .willReturn(product);
        mockMvc.perform(post("/product/addProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    /**
     * Should delete the product with the given product id.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteProduct() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.
                delete("/product/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Should get product by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void should_get_person_by_id() throws Exception {
        BDDMockito.given(productService.getProductById(1))
                .willReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.
                        get("/product/1")).
                andExpect(status().isOk());
    }

}
