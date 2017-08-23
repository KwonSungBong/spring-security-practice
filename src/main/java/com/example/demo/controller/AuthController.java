package com.example.demo.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by whilemouse on 17. 8. 21.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/token")
    public CsrfToken main(CsrfToken token) {
        return token;
    }

    @RequestMapping("/me")
    @ResponseBody
    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,String> test() {
        Map<String, String> test = new HashMap<>();
        test.put("1","test1");
        test.put("2","test2");
        test.put("3","test3");
        test.put("4","test4");

        return test;
    }

}