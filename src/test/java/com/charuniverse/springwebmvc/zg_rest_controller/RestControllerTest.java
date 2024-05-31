package com.charuniverse.springwebmvc.zg_rest_controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddTodo() throws Exception {
        mockMvc.perform(
                        post("/todos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("todo", "Belajar Spring Web MVC")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Belajar Spring Web MVC"))
                );
    }

    @Test
    void testGetTodo() throws Exception {
        mockMvc.perform(get("/todos").accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Belajar Spring Web MVC"))
                );
    }
}