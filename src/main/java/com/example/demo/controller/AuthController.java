package com.example.demo.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
    public String test() {
        return "test";
    }

}