package com.code.questionnaireSystem.controller;

import com.code.questionnaireSystem.pojo.User;
import com.code.questionnaireSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/queryAllUsers")
    public List<User> queryAllUsers() {
        return userService.queryAllUsers();
    }
}
