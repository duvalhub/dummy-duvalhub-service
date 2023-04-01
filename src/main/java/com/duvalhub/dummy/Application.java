package com.duvalhub.dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.duvalhub.dummy", "com.acme"})
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class);
    }
}
