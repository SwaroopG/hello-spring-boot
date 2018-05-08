package com.poorjar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HelloController {
    @RequestMapping("/")
    public String handleRequest() {
        return "Hello Spring Boot!";
    }
}
