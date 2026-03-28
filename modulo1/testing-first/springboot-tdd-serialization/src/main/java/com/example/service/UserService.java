package com.example.service;

import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ObjectMapper mapper = new ObjectMapper();

    public String serialize(User user) throws Exception {
        User usuario = new User(1L , "Maria" , "maria@email.com");

        return mapper.writeValueAsString(usuario);
    }

    public User deserialize(String json) throws Exception {
        User user = mapper.readValue(json, User.class);
    
        if (user.getEmail()==null || user.getName()==null || user.getId()==null) {
            throw new Exception();
        }

        return user;    
    }
}
