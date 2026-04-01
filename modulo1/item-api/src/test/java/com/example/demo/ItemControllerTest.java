package com.example.demo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Item;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void shouldShowAllItens(){
        ResponseEntity<String> response = restTemplate.getForEntity("/api/itens/", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void shouldReturnItemByTheId(){
        ResponseEntity<Item> response = restTemplate.postForEntity("/api/itens/", new Item("água" , "garrafa"), Item.class);
        Long id = response.getBody().getId();

        String uri = "/api/itens/" + id;

        ResponseEntity<Item> newResponse = restTemplate.getForEntity(uri, Item.class);

        assertThat(newResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(newResponse.getBody().getNome()).isEqualTo("água");
        assertThat(newResponse.getBody().getDescricao()).isEqualTo("garrafa");
    }

    @Test
    void shouldReturnAnErrorByTheInexistentId(){
        String uri = "/api/itens/10000";
        ResponseEntity<Item> response = restTemplate.getForEntity(uri, Item.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldReturnAn201AndTheId(){
        ResponseEntity<Item> response = restTemplate.postForEntity("/api/itens/", new Item("refri" , "lata"), Item.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getHeaders().getLocation()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
    }
}
