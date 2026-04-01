package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("api/")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    // ainda tenho que aprender mais sobre como retornar 201 e o id do objeto. pode me ajudar com isso também?
    @PostMapping("itens/")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item saved = itemService.addItem(item);
        URI loc = URI.create("/api/itens/" + saved.getId());

        return ResponseEntity.created(loc).body(saved);
    }

    @GetMapping("itens/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable Long id){
        Optional<Item> item = itemService.findItemById(id);

        if(item.isPresent()){
            return ResponseEntity.ok(item.get());
        } 
        return ResponseEntity.notFound().build();
    }

    @GetMapping("itens/")
    public ResponseEntity <List<Item>> showAllItens(){
        return ResponseEntity.ok(itemService.showAllItens());
    }
}
