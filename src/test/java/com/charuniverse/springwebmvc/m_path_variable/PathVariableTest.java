package com.charuniverse.springwebmvc.m_path_variable;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PathVariableTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRequestHeaderValid() throws Exception {
        mockMvc.perform(get("/orders/1/products/2"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Order: 1, Product: 2"))
                );
    }
}