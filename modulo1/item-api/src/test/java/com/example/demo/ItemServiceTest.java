package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    void shouldCreateAnItemSuccessfully() throws Exception{
        Item item = new Item("água" , "garrafa de água");
        Item saved = itemService.addItem(item);
        assertThat(saved.getNome()).isEqualTo("água");
        assertThat(saved.getDescricao()).isEqualTo("garrafa de água");
    }

    @Test
    void shouldReturnItemWhenIdExists() throws Exception{
        Item item = new Item("água" , "garrafa de água");
        Item saved = itemService.addItem(item);

        Optional<Item> found = itemService.findItemById(saved.getId());

        assertThat(found).isNotNull();
    }

    @Test
    void shouldReturnListOfItems() throws Exception{
        Item item1 = new Item("água" , "garrafa de água");
        Item item2 = new Item("suco" , "garrafa de suco");
        Item item3 = new Item("refri" , "garrafa de refri");

        itemService.addItem(item1); itemService.addItem(item2); itemService.addItem(item3);

        List<Item> allItens = itemService.showAllItens();

        assertThat(allItens).extracting(Item:: getNome).contains("água" , "suco" , "refri");
    }
}
