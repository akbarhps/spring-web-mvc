package com.charuniverse.springwebmvc.k_response_content_type;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ResponseContentTypeTest {

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
                        header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                        content().string(Matchers.containsString("Hello gemink"))
                );
    }
}