package com.itwang.service;

import com.itwang.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    //fallback指定的类必须实现@FeignClient标记的接口。DeptClientService
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService(){
            @Override
            public Dept get(long id) {
                Dept dept=new Dept();
                dept.setDeptno(id);
                dept.setDname("没有该id对应的信息");
                dept.setDb_source("no this database in MySQL");
                return dept;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };

    }
}
