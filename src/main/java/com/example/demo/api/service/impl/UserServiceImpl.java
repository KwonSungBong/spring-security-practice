package com.example.demo.api.service.impl;

import com.example.demo.api.repository.UserRepository;
import com.example.demo.api.service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ksb on 2017. 8. 19..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void removeUser(Long id) {

    }

    @Override
    public List<User> listUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

}
