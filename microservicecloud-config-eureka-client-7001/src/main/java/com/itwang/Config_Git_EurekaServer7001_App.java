package com.itwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class Config_Git_EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServer7001_App.class,args);
    }
}
