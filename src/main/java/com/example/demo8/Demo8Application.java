package com.example.demo8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.course.server")
@ComponentScan("com.example.demo8")
@ComponentScan("com.course.config")
@ComponentScan("com.course.cases")
@ComponentScan("com.course.bean")
@ComponentScan("com.course.model")
@ComponentScan("com.course.utils")
@ComponentScan("com.course.controller")
public class Demo8Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo8Application.class, args);
    }

}
