package com.charuniverse.springwebmvc.zc_argument_resolver;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
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
class ArgumentResolverTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testArgumentResolverSuccess() throws Exception {
        mockMvc.perform(get("/partner/current").header("X-API-KEY", "awek"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("awek : awek partner"))
                );
    }

    @Test
    void testArgumentResolverFailure() throws Exception {
        Assertions.assertThrows(Exception.class, () -> mockMvc.perform(get("/partner/current")));
    }
}