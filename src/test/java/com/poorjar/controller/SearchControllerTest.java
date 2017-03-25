package com.poorjar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.Lists;
import com.poorjar.application.MainApplication;
import com.poorjar.entity.SearchItem;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchControllerTest {
    private static Logger LOGGER = Logger.getLogger(SearchControllerTest.class);

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testMainRequest() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/", String.class);

        LOGGER.info("********Response" + response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody(), equalTo("Hello Spring Boot!"));
    }

    @Test
    public void testSearchRequest() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/search/description/swaroop/", String.class);

        LOGGER.info("********Response" + response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody(), containsString(getExpectedSearchResponse()));
    }

    private String getExpectedSearchResponse() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(Lists.newArrayList(new SearchItem(1, "Hello World"), new SearchItem(2, "Hello Track")));
    }
}
