package com.charuniverse.springwebmvc.w_exception_handler;

import com.charuniverse.springwebmvc.model.CreateAddressRequest;
import com.charuniverse.springwebmvc.model.CreatePersonRequest;
import com.charuniverse.springwebmvc.model.CreateSocialMediaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testExceptionHandler() throws Exception {
        CreatePersonRequest person = new CreatePersonRequest();

        CreateAddressRequest address = new CreateAddressRequest();
        address.setStreet("Jl. Gemink");
        address.setCity("Gemink");
        address.setCountry("Gemink");
        address.setPostalCode("12345");

        CreateSocialMediaRequest socialMedia = new CreateSocialMediaRequest();
        socialMedia.setName("instagram");
        socialMedia.setUrl("https://instagram.com/akbargggemink");

        person.setAddress(address);
        person.setHobbies(List.of("coding", "reading"));
        person.setSocialMedias(List.of(socialMedia));

        String jsonRequest = objectMapper.writeValueAsString(person);

        mockMvc.perform(
                        post("/api/person")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(jsonRequest)
                )
                .andExpectAll(
                        status().isBadRequest(),
                        content().string(Matchers.containsString("Validation error"))
                );
    }
}