package com.itwang.service;

import com.itwang.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//fallback指定的类必须实现@FeignClient标记的接口。DeptClientService
//fallback服务降级处理
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable(value = "id") long id);

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();
}
