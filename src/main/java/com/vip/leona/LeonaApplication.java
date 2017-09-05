package com.vip.leona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.vip")
public class LeonaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeonaApplication.class, args);
    }
}
