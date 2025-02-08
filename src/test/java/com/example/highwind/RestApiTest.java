package com.example.highwind;

import com.example.highwind.Entity.Spaceship;
import com.example.highwind.Service.SpaceshipService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestApi.class)
class RestApiTest {

    @Autowired
    private MockMvc mockMvc;


    private SpaceshipService spaceshipService;

    @Autowired
    private ObjectMapper objectMapper;

    private Spaceship spaceship;

    @BeforeEach
    void setUp() {
        spaceship = new Spaceship( 100L, 200L, 300L, 400, 45.0f);
        spaceship.setId(1);
        spaceship.setMasse(100L);
        spaceship.setX(200L);
        spaceship.setY(300L);
        spaceship.setSurfaceVoile(400);
        spaceship.setAngleVoile(45.0f);
    }

    @Test
    void createSpaceship() throws Exception {
       // when(spaceshipService.createSpaceship(any(Long.class), any(Long.class), any(Long.class), any(Integer.class), any(Float.class)))
                //.thenReturn(spaceship);

        mockMvc.perform(post("/spaceship/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"masse\":100,\"x\":200,\"y\":300,\"surfaceVoile\":400,\"angleVoile\":45.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(spaceship.getId()))
                .andExpect(jsonPath("$.masse").value(spaceship.getMasse()))
                .andExpect(jsonPath("$.x").value(spaceship.getX()))
                .andExpect(jsonPath("$.y").value(spaceship.getY()))
                .andExpect(jsonPath("$.surfaceVoile").value(spaceship.getSurfaceVoile()))
                .andExpect(jsonPath("$.angleVoile").value(spaceship.getAngleVoile()));
    }

    @Test
    void updateSpaceship() throws Exception {
        //when(spaceshipService.updateSpaceship(any(Spaceship.class))).thenReturn(spaceship);

        mockMvc.perform(post("/spaceship/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(spaceship)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(spaceship.getId()))
                .andExpect(jsonPath("$.masse").value(spaceship.getMasse()))
                .andExpect(jsonPath("$.x").value(spaceship.getX()))
                .andExpect(jsonPath("$.y").value(spaceship.getY()))
                .andExpect(jsonPath("$.surfaceVoile").value(spaceship.getSurfaceVoile()))
                .andExpect(jsonPath("$.angleVoile").value(spaceship.getAngleVoile()));
    }

    @Test
    void getSpaceship() throws Exception {
        when(spaceshipService.getSpaceship(anyInt())).thenReturn(spaceship);

        mockMvc.perform(get("/spaceship/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(spaceship.getId()))
                .andExpect(jsonPath("$.masse").value(spaceship.getMasse()))
                .andExpect(jsonPath("$.x").value(spaceship.getX()))
                .andExpect(jsonPath("$.y").value(spaceship.getY()))
                .andExpect(jsonPath("$.surfaceVoile").value(spaceship.getSurfaceVoile()))
                .andExpect(jsonPath("$.angleVoile").value(spaceship.getAngleVoile()));
    }

    @Test
    void deleteSpaceship() throws Exception {
        mockMvc.perform(delete("/spaceship/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}