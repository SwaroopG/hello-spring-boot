package com.poorjar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.poorjar.controller.CityController;
import com.poorjar.controller.ExceptionController;
import com.poorjar.controller.HelloController;
import com.poorjar.controller.SearchController;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.poorjar")
public class MainApplication extends SpringBootServletInitializer
{
    private static Class<MainApplication> entryPointClass = MainApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(entryPointClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(entryPointClass, HelloController.class, SearchController.class, CityController.class, ExceptionController.class);
    }
}