package com.charuniverse.springwebmvc.d_integration_test.c_mock_mvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private Integer port;

    @Test
    void helloGuest() {
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity("http://localhost:" + port + "/hello", String.class);
        String responseBody = responseEntity.getBody();
        Assertions.assertNotNull(responseBody);
        Assertions.assertTrue(responseBody.contains("Hello Guest"));
    }

    @Test
    void helloName() {
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity("http://localhost:" + port + "/hello?name=gemink", String.class);
        String responseBody = responseEntity.getBody();
        Assertions.assertNotNull(responseBody);
        Assertions.assertTrue(responseBody.contains("Hello gemink"));
    }
}
