package com.itwang.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor  //全参构造
@NoArgsConstructor   //无参构造
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String db_source;  //来自哪个数据库

}
