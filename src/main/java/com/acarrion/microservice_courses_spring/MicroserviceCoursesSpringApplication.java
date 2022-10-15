package com.acarrion.microservice_courses_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.acarrion.controllers"})
public class MicroserviceCoursesSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCoursesSpringApplication.class, args);
    }

}
