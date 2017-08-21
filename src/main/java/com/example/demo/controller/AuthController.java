package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by whilemouse on 17. 8. 21.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * Return the principal identifying the logged in user
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/me", method = RequestMethod.POST)
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
