package com.itwang.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
//    从github上指定的配置文件中读取配置文件信息
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        String s="applicationName:"+applicationName+"\t eurekaServers:"+eurekaServers;
        System.out.println("**********str:"+s);
        return "applicationName:"+applicationName+"|  eurekaServers:"+eurekaServers+"|   port:"+port;
    }
}
