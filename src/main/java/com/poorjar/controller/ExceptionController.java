package com.poorjar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ExceptionController {
    @RequestMapping("/exception")
    public String handleRequest() {
        throw new NullPointerException();
    }
}
