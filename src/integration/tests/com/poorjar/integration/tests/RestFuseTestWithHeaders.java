package com.poorjar.integration.tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.RequestContext;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@Ignore
@RunWith(HttpJUnitRunner.class)
public class RestFuseTestWithHeaders
{
    @Rule
    public Destination restFuse = getDestination();

    @Context
    private Response actualResponse;

    @HttpTest(method = Method.GET, path = "/", order = 1)
    public void headerTest()
    {
        System.out.println(actualResponse.getStatus());
        System.out.println(actualResponse.getBody());
        Assert.assertEquals("Checking HTTP Response Code", 200, actualResponse.getStatus());
        Assert.assertEquals("Expected and actual response do not match!", getExpectedResponse(), actualResponse.getBody());
    }

    private Destination getDestination()
    {
        Destination destination = new Destination(this, "http://localhost:8080");
        RequestContext context = destination.getRequestContext();
        context.addHeader("header1", "HEADER");
        context.addHeader("header2", "HEADER");
        return destination;
    }

    private String getExpectedResponse()
    {
        return "Hello Spring Boot!";
    }
}