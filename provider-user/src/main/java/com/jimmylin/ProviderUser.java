package com.jimmylin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * main application
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderUser
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProviderUser.class);
    }
}
