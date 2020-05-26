package com.itwang.controller;

import com.itwang.entities.Dept;
import com.itwang.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired //通过@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
//    一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")  //添加熔断机制，当服务端出现故障直接返回预期结果
    public Dept get(@PathVariable(value = "id") Long id){
        Dept dept=deptService.get(id);
        if (null==dept){
            throw new RuntimeException("该ID"+id+"没有对应的信息");
        }
        return dept;
    }
//绑定上面接口的@GetMapping("/dept/get/{id}")
    public Dept processHystrix_Get(@PathVariable("id")Long id){
        Dept dept=new Dept();
        dept.setDeptno(id);
        dept.setDname("没有该id对应的信息");
        dept.setDb_source("no this database in MySQL");
        return dept;
    }

}
