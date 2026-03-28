package com.example.service;

import com.example.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void shouldSerializeUser() throws Exception {
        UserService service = new UserService();
        User user = new User(1L, "Maria", "maria@email.com");

        String json = service.serialize(user);

        assertNotNull(json);
        assertTrue(json.contains("Maria"));
    }

    @Test
    void shouldDeserializeUser() throws Exception {
        UserService service = new UserService();
        String json = "{\"id\":1,\"name\":\"Maria\",\"email\":\"maria@email.com\"}";

        User user = service.deserialize(json);

        assertEquals("Maria", user.getName());
        assertEquals("maria@email.com", user.getEmail());
    }

    @Test
    void shouldFailWhenJsonIsInvalid() throws Exception{
        UserService userService = new UserService();

        String json = "{2 , joao , joao@email.com}";
        
        // User user = userService.deserialize(json);
        
        assertThrows(Exception.class, () -> userService.deserialize(json));
        
    }

    @Test
    void shouldFailWhenDataIsInvalid() throws Exception{
        UserService userService = new UserService();
        String json = "{\"id\":3}";

        // User user = userService.deserialize(json);

        assertThrows(Exception.class, () -> userService.deserialize(json));
    }
}
