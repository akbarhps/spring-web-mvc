package com.charuniverse.springwebmvc.p_request_body;

import com.charuniverse.springwebmvc.model.HelloRequest;
import com.charuniverse.springwebmvc.model.HelloResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RequestBodyTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testUploadFileRequest() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("gemink");

        mockMvc.perform(
                        post("/body/hello")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpectAll(
                        status().isOk(),
                        header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.APPLICATION_JSON_VALUE))
                )
                .andExpect(result -> {
                    String responseBody = result.getResponse().getContentAsString();
                    HelloResponse response = objectMapper.readValue(responseBody, HelloResponse.class);
                    Assertions.assertEquals("Hello gemink", response.getHello());
                });

    }
}