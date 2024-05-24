package com.charuniverse.springwebmvc.t_model_attribute;

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
class ModelAttributeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testModelAttribute() throws Exception {
        mockMvc.perform(
                        post("/person")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("firstName", "akbar")
                                .param("middleName", "gg")
                                .param("lastName", "gemink")
                                .param("email", "akbargggemink@gmail.com")
                                .param("phone", "123")
                                .param("address.street", "Jl. Gemink")
                                .param("address.city", "Gemink")
                                .param("address.country", "Gemink")
                                .param("address.postalCode", "12345")
                                .param("hobbies[0]", "coding")
                                .param("hobbies[1]", "reading")
                                .param("socialMedias[0].name", "instagram")
                                .param("socialMedias[0].url", "https://instagram.com/akbargggemink")
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Success create person akbar gg gemink with email akbargggemink@gmail.com and phone 123 and address Jl. Gemink Gemink Gemink 12345"))
                );
    }
}