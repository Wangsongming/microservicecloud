package com.itwang.service;

import com.itwang.entities.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept get(Long id);

    public List<Dept> findAll();
}
