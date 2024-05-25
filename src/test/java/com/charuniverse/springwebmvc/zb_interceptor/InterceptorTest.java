package com.charuniverse.springwebmvc.zb_interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InterceptorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testInterceptor() throws Exception {
        mockMvc.perform(get("/user/current"))
                .andExpect(status().is3xxRedirection());
    }
}