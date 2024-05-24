package com.charuniverse.springwebmvc.j_request_content_type;

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
class RequestContentTypeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRequestContentType() throws Exception {
        mockMvc.perform(
                        post("/form/hello")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", "gemink")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello gemink"))
                );
    }
}