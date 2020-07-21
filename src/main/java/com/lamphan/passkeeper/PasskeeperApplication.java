package com.lamphan.passkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PasskeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasskeeperApplication.class, args);
        System.out.println("===========");
    }

}
