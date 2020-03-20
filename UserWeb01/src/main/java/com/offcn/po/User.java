package com.offcn.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 还原出来
 * 根本不读数据库
 * 表现层实实体
 * 不和数据库进行交互
 */
@Data
@NoArgsConstructor  //无参构造
@AllArgsConstructor //全参构造
public class User {


    private Long id;

    private String name;

    private Integer age;
}
