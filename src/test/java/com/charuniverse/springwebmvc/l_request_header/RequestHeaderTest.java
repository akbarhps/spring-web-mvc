package com.charuniverse.springwebmvc.l_request_header;

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
class RequestHeaderTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRequestHeaderValid() throws Exception {
        mockMvc.perform(
                        get("/header/token")
                                .header("X-TOKEN", "gemink")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Token is valid"))
                );
    }

    @Test
    void testRequestHeaderInvalid() throws Exception {
        mockMvc.perform(
                        get("/header/token")
                                .header("X-TOKEN", "invalid")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Token is invalid"))
                );
    }
}