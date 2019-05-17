package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.pojo.User;
import com.code.questionnaireSystem.utils.Result;

public interface UserService {

	Result login(String userName, String password);

	Result addUser(String userName, String userPassword, String userPhone, String userEmail);

	Result valiate(String type, String value);

	Result update(User user);
}