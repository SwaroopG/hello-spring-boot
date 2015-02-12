package com.poorjar.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class FirstController
{
    @RequestMapping("/first")
    @ResponseBody
    public String handleRequest()
    {
        return "Hello Sprint Boot! First Controller";
    }

}