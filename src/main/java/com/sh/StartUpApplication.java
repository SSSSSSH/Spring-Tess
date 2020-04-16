package com.sh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class StartUpApplication {


    public static void main(String[] args) {
        SpringApplication.run(StartUpApplication.class, args);
    }
}
