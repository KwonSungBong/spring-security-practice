package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * Created by ksb on 2017. 8. 19..
 */
public interface UserService {

    void removeUser(Long id);
    List<User> listUsers();

}
