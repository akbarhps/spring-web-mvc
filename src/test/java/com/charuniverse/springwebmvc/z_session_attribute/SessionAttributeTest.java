package com.charuniverse.springwebmvc.z_session_attribute;

import com.charuniverse.springwebmvc.model.User;
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
class SessionAttributeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSessionAttribute() throws Exception {
        mockMvc.perform(get("/user/current").sessionAttr("user", new User("Andi")))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Andi"))
                );
    }
}