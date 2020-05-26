package com.itwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//添加Feign，@EnableFeignClients中已经默认打开了断路器功能，所以这里的启动类上不需要再加@EnableCircuitBreaker注解,Feign也是客户端的负载均衡器
@EnableFeignClients(basePackages = {"com.itwang"})  //因为@FeignClient接口注解在api项目里，所以这里扫描的com.itwang是api项目下的
//@ComponentScan("com.itwang")
public class DeptConsumerFeign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_App.class,args);
    }
}
