package com.usrapi.demo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

// import org.apache.tomcat.util.http.parser.MediaType; // Removed duplicate import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usrapi.demo.controller.UserController;
import com.usrapi.demo.model.User;
import com.usrapi.demo.model.Company;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User testUser;
    private List<User> testUsers;
    private Company testCompany;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testCompany = new Company(); 
        testUser.setId(1L);
        testUser.setName("Vorawee");
        testUser.setUsername("gearkiskee");
        testUser.setEmail("vorawee.wilwan@example.com");
        testUser.setPhone("123-456-7890");
        testUser.setWebsite("vorawee.com");
        testCompany.setName(("Bangkok bank"));
        testCompany.setCatchPhrase("null");
        testCompany.setBs( "iTrade, Bualuang iSupply, Bualuang e-Guarantee, Customs Paperless e-Payment Trade iReport");
        testUser.setCompany(testCompany);

        User anotherUser = new User();
        anotherUser.setId(2L);
        anotherUser.setName("Another User");
        anotherUser.setUsername("anotheruser");
        anotherUser.setEmail("another@example.com");

        testUsers = Arrays.asList(testUser, anotherUser);
    }

    @Test
    void getAllUsers_ShouldReturnAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(testUsers);

        mockMvc.perform(get("/users")
        .contentType(MediaType.APPLICATION_JSON_VALUE)) 
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].name", is("Vorawee")))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[1].name", is("Another User")));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getUserById_ShouldReturnUser() throws Exception {
        when(userService.getUserById(1L)).thenReturn(testUser);

        mockMvc.perform(get("/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Vorawee")))
                .andExpect(jsonPath("$.email", is("vorawee.wilwan@example.com")));

        verify(userService, times(1)).getUserById(1L);
    }




}
