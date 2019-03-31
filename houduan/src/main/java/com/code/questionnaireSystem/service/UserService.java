package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.pojo.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUsers();
}