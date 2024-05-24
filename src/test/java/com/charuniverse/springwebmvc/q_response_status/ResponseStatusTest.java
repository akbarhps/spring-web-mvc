package com.charuniverse.springwebmvc.q_response_status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ResponseStatusTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testResponseStatus() throws Exception {
        mockMvc.perform(delete("/products/1"))
                .andExpect(status().isAccepted());
    }
}