package com.example.woc.controller;


import com.example.woc.entity.User;
import com.example.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(User user){
        return userService.login(user);
    }

    @PostMapping("/regist")
    public String regist(User user){
        return userService.regist(user);
    }



}
