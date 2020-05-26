package com.itwang.controller;

import com.itwang.entities.Dept;
import com.itwang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired //通过@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.findAll();
    }

    @GetMapping(value = "/dept/discovery")
    public Object discovery(){
        List<String> list=client.getServices();    //得到所有注册的微服务
        System.out.println("-----------------"+list);
        List<ServiceInstance> serviceInstanceList=client.getInstances("MICROSERVICECLOUD-DEPT");   //得到微服务实例
        for (ServiceInstance element:serviceInstanceList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return  this.client;
    }
}
