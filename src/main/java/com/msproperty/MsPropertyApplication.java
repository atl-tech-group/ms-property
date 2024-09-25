package com.msproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPropertyApplication.class, args);
    }
}
