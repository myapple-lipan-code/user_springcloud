package com.offcn.dao;

import com.offcn.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 进行  UserDao 的dao层操作工具类     指定泛型User  主键类型Long
 */
public interface UserDao extends JpaRepository<User,Long> {
}
