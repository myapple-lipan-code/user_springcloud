package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor  //无参构造
@AllArgsConstructor //全参构造
public class User {

    //主键自增
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = true,length = 200)
    private String name;
    @Column(name = "age",nullable = true,length = 4)
    private Integer age;
}
