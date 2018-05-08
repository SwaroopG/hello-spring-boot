package com.poorjar.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public final class MainApplicationIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRequest() throws Exception {
        String body = this.restTemplate.getForObject("/", String.class);
        HttpStatus status = this.restTemplate.getForEntity("/", String.class).getStatusCode();

        System.out.println(body);
        System.out.println(status.toString());

        assertEquals(HttpStatus.OK, status);
        assertThat(body).isEqualTo("Hello Spring Boot!");
    }
}
