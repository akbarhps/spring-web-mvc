package com.charuniverse.springwebmvc.s_cookie;

import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class CookieTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCookieSuccess() throws Exception {
        mockMvc.perform(
                        post("/auth/login")
                                .param("username", "admin")
                                .param("password", "admin")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Login success")),
                        cookie().exists("username"),
                        cookie().value("username", Matchers.is("admin"))
                );
    }

    @Test
    void testCookieFailure() throws Exception {
        mockMvc.perform(
                        post("/auth/login")
                                .param("username", "admin")
                                .param("password", "admin2")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpectAll(
                        status().isUnauthorized(),
                        content().string(Matchers.containsString("Login failed")),
                        cookie().doesNotExist("username")
                );
    }

    @Test
    void testGetCookie() throws Exception {
        mockMvc.perform(get("/auth/user").cookie(new Cookie("username", "admin")))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello admin"))
                );
    }
}