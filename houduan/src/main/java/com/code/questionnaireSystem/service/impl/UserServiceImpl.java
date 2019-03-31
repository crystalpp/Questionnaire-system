package com.code.questionnaireSystem.service.impl;

import com.code.questionnaireSystem.mapper.UserMapper;
import com.code.questionnaireSystem.pojo.User;
import com.code.questionnaireSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }
}