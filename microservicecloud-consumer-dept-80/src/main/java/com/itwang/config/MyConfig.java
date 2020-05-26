package com.itwang.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

//    注册RestTemplate
    @Bean
    @LoadBalanced  //加载 Ribbon 负载均衡的工具，默认算法是轮询，挨个轮询一个一次
    // 使得RestTemplate调用接口时使用负载均衡算法，随机的对接到配置到eureka服务中心 相应程序名下的 可用的实例微服务生产者8001,8002,8003
    // 这里eureka注册的程序名是MICROSERVICECLOUD-DEPT
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    采用IRule随机算法，覆盖以前Ribbon默认的轮询算法
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
