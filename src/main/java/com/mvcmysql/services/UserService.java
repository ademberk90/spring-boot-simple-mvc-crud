package com.mvcmysql.services;

import java.util.List;

import com.mvcmysql.entity.User;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    void save(User id);
    void deleteById(Integer id);
}
