package com.poorjar.controller;

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

@Ignore
@RunWith(HttpJUnitRunner.class)
public class SearchControllerTest
{
    @Rule
    public Destination destination = new Destination(this, "http://localhost:8080/search/description/swaroop");

    @Context
    private Response actualResponse;

    @HttpTest(method = Method.GET, path = "/")
    public void testRestAPI()
    {
        Assert.assertEquals("Checking HTTP Response Code", 200, actualResponse.getStatus());
        System.out.println(actualResponse.getStatus());
        System.out.println(actualResponse.getBody());
    }
}
