package com.shibing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.shibing"})
public class IncidentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncidentManagementApplication.class, args);
    }
}
