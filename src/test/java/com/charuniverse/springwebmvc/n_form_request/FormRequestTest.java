package com.charuniverse.springwebmvc.n_form_request;

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
class FormRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFormRequest() throws Exception {
        mockMvc.perform(
                        post("/form/person")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", "gemink")
                                .param("birthDate", "2000-01-01")
                                .param("address", "Jakarta")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Success create Person with name: gemink, birthDate: 2000-01-01, address: Jakarta"))
                );
    }
}