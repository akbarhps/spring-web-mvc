package com.charuniverse.springwebmvc.zi_servlet_integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServletIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testServlet() {
        String url = "http://localhost:" + port + "/servlet/hello";
        String response = restTemplate.getForObject(url, String.class);
        Assertions.assertEquals("Hello from Servlet!", response.trim());
    }
}