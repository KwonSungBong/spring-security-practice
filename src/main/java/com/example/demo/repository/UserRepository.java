package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ksb on 2017. 8. 19..
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
