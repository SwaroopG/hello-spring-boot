package com.poorjar.application;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;
import com.poorjar.controller.FirstController;
import com.poorjar.controller.MainController;
import com.poorjar.controller.SecondController;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MainApplication
{
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
        List components = Lists.newArrayList(MainController.class, FirstController.class, SecondController.class);
        ApplicationContext ctx = SpringApplication.run(components.toArray(), args);

        System.out.println("************************************************");
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        System.out.println("************************************************");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames)
        {
            System.out.println(beanName);
        }
    }
}