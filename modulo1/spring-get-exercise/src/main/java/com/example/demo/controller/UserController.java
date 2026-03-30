package com.example.demo.controller;

import com.example.demo.model.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1L, "Maria"));
        users.add(new User(2L, "João"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<User> findById(@PathVariable Long requestedId){
        for (User u: users){
            if(u.getId().equals(requestedId)){
                return ResponseEntity.ok(u); 
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{requestedName}")
    public ResponseEntity<User> findByName(@PathVariable String requestedName){
        for(User u: users){
            if(u.getName().equals(requestedName)){
                return ResponseEntity.ok(u);
            }
        }
        return ResponseEntity.notFound().build();
    }*/

    
}
