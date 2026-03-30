package com.example;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;

public class UserControllerTest {
    
    @Test
    public void shouldReturnUserWhenIdExists() throws Exception{
        UserController userController = new UserController();

        ResponseEntity<User> response = userController.findById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    public void shouldReturnNotFoundWhenIdIsInvalid() throws Exception{
        UserController userController = new UserController();

        ResponseEntity<User> response = userController.findById(30L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
