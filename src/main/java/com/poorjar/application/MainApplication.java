package com.poorjar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.collect.Lists;
import com.poorjar.controller.HelloController;
import com.poorjar.controller.SearchController;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.poorjar.controller")
public class MainApplication
{
    public static void main(String[] args) throws Exception
    {
        @SuppressWarnings("unchecked")
        Object[] components = Lists.newArrayList(HelloController.class, SearchController.class).toArray();
        SpringApplication.run(components, args);
    }
}