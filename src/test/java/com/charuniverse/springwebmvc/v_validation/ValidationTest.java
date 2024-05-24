package com.charuniverse.springwebmvc.v_validation;

import com.charuniverse.springwebmvc.model.CreateAddressRequest;
import com.charuniverse.springwebmvc.model.CreatePersonRequest;
import com.charuniverse.springwebmvc.model.CreateSocialMediaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
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
class ValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testValidationAPISuccess() throws Exception {
        CreatePersonRequest person = new CreatePersonRequest();
        person.setFirstName("akbar");
        person.setMiddleName("gg");
        person.setLastName("gemink");
        person.setEmail("akbargggemink@gmail.com");
        person.setPhone("123");

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
                        status().isOk(),
                        content().json(jsonRequest)
                );
    }

    @Test
    void testValidationAPIFailure() throws Exception {
        CreatePersonRequest person = new CreatePersonRequest();
        person.setFirstName("akbar");
        person.setMiddleName("gg");
        person.setLastName("gemink");
        person.setEmail("akbargggemink@gmail.com");
        person.setPhone("123");

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
                        status().isOk(),
                        content().json(jsonRequest)
                );
    }

    @Test
    void testValidationFail() throws Exception {
        mockMvc.perform(
                        post("/person")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
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
                        status().isBadRequest()
                );
    }
}