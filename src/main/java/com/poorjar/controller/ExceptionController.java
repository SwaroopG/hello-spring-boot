package com.poorjar.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public final class ExceptionController
{
    @RequestMapping("/exception")
    public String handleRequest()
    {
        throw new NullPointerException();
    }
}
