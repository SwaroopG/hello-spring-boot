package com.poorjar.application;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public final class MainApplicationIntegrationTest
{
    RestTemplate template = new TestRestTemplate();

    @Test
    public void testRequest() throws Exception
    {
        String body = template.getForEntity("http://localhost:9000", String.class).getBody();
        HttpStatus status = template.getForEntity("http://localhost:9000", String.class).getStatusCode();

        System.out.println(body);
        System.out.println(status.toString());

        assertEquals(status, HttpStatus.OK);
        assertThat(body, containsString("Hello Spring Boot!"));
    }
}
