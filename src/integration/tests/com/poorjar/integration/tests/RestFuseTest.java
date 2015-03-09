package com.poorjar.integration.tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.Lists;
import com.poorjar.entity.SearchItem;

@Ignore
@RunWith(HttpJUnitRunner.class)
public class RestFuseTest
{
    @Rule
    public Destination destination = new Destination(this, "http://localhost:8080");

    @Context
    private Response actualResponse;

    @HttpTest(method = Method.GET, path = "/search/description/swaroop")
    public void pingTest() throws Exception
    {
        System.out.println(actualResponse.getStatus());
        System.out.println(actualResponse.getBody());
        Assert.assertEquals("Checking HTTP Response Code", 200, actualResponse.getStatus());
        Assert.assertEquals("Expected and actual response do not match!", getExpectedResponse(), actualResponse.getBody());
    }

    private String getExpectedResponse() throws Exception
    {
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(Lists.newArrayList(new SearchItem(1, "Hello World"), new SearchItem(2, "Hello Track")));
    }
}
