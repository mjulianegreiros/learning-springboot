package com.example.catalog;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldSaveAProduct(){
        Product product = new Product("water" , 2.50);
        productRepository.save(product);
        
        List<Product> products = productRepository.findAll();
        assertThat(products).isNotEmpty();
        assertThat(products.get(0).getName()).isEqualTo("water");
        assertThat(products.get(0).getPrice()).isEqualTo(2.50);
    }


}
