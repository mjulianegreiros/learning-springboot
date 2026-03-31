package com.example.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.catalog.model.Product;
import com.example.catalog.repository.ProductRepository;
import com.example.catalog.controller.ProductController;

@DataJpaTest
public class ProductControllerTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldCreateAProduct(){
        ProductController controller = new ProductController(productRepository);

        Product product = new Product("water" , 2.50);
        ResponseEntity<Product> responseEntity = controller.addProduct(product);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getHeaders().getLocation().toString()).isEqualTo("/api/create/" + responseEntity.getBody().getId());
        assertThat(responseEntity.getBody().getName()).isEqualTo("water");
        assertThat(responseEntity.getBody().getPrice()).isEqualTo(2.50);
    }


}
