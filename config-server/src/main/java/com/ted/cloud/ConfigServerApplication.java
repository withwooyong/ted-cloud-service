package com.ted.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * dev, stg, prd
     * $ curl -X GET "http://localhost:8080/config/dev"
     * $ curl -X GET "http://localhost:8080/config/stg"
     * $ curl -X GET "http://localhost:8080/config/prd"
     * GET /{application}/{profile}[/{label}]
     * GET /{application}-{profile}.yml
     * GET /{label}/{application}-{profile}.yml
     * GET /{application}-{profile}.properties
     * GET /{label}/{application}-{profile}.properties
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
