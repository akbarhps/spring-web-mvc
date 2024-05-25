package com.charuniverse.springwebmvc.ze_model_and_view;

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
class ModelAndViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testModelAndView() throws Exception {
        mockMvc.perform(get("/web/hello").queryParam("name", "Kumis"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("View menggunakan kumis")),
                        content().string(Matchers.containsString("Hello Kumis"))
                );
    }
}