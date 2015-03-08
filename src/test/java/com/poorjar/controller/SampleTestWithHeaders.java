package com.poorjar.controller;

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
public class SampleTestWithHeaders
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
        Destination destination = new Destination(this, "http://localhost:8205/rightsinfo/1?sname=rightsinfo&cmd=ping");
        RequestContext context = destination.getRequestContext();
        context.addHeader("sslclientc", "ARRIS");
        context.addHeader("ARRIS_MSO", "ARRIS");
        context.addHeader("BIGIPSign", "test");
        return destination;
    }

    private String getExpectedResponse()
    {
        return "<rpksmsresp><rc>1100</rc><msg>Invalid request.</msg></rpksmsresp>";
    }
}
