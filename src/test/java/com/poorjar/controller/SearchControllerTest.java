package com.poorjar.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.Lists;
import com.poorjar.application.MainApplication;
import com.poorjar.entity.SearchItem;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class SearchControllerTest
{
    private static Logger LOGGER = Logger.getLogger(SearchControllerTest.class);

    private static String baseUrl = "http://localhost:9000/";
    private static String searchUrl = "http://localhost:9000/search/description/swaroop/";

    RestTemplate template = new TestRestTemplate();

    @Test
    public void testMainRequest() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(baseUrl, String.class);

        LOGGER.info("********Response" + response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody(), equalTo("Hello Spring Boot!"));
    }

    @Test
    public void testSearchRequest() throws Exception
    {
        ResponseEntity<String> response = template.getForEntity(searchUrl, String.class);

        LOGGER.info("********Response" + response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody(), containsString(getExpectedSearchResponse()));
    }

    private String getExpectedSearchResponse() throws Exception
    {
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(Lists.newArrayList(new SearchItem(1, "Hello World"), new SearchItem(2, "Hello Track")));
    }
}
