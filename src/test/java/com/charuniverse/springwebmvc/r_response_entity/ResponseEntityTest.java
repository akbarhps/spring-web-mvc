package com.charuniverse.springwebmvc.r_response_entity;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ResponseEntityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testResponseEntitySuccess() throws Exception {
        mockMvc.perform(
                        post("/auth/login")
                                .param("username", "admin")
                                .param("password", "admin")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Login success"))
                );
    }

    @Test
    void testResponseEntityFailure() throws Exception {
        mockMvc.perform(
                        post("/auth/login")
                                .param("username", "admin")
                                .param("password", "admin2")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpectAll(
                        status().isUnauthorized(),
                        content().string(Matchers.containsString("Login failed"))
                );
    }
}