package com.code.questionnaireSystem.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.CustomUserMapper;
import com.code.questionnaireSystem.mapper.UserMapper;
import com.code.questionnaireSystem.pojo.User;
import com.code.questionnaireSystem.pojo.UserExample;
import com.code.questionnaireSystem.service.UserService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CustomUserMapper customUserMapper;

	@Override
	public Result login(String userName, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(password);
		User u = customUserMapper.login(user);
		if (null != u)
			return Result.success(u);
		else
			return Result.failure(ResultCode.FAIL);

	}

	@Override
	public Result addUser(String userName, String userPassword, String userPhone, String userEmail) {
		// TODO Auto-generated method stub
		System.out.println(userName);
		String id = UUID.randomUUID().toString().substring(0, 10);
		User user = new User(id, userName, userPassword, userPhone, userEmail);
		int num = userMapper.insertSelective(user);
		if (num >= 1) {
			return Result.success();
		} else {
			return Result.failure(ResultCode.FAIL);
		}
		// return null;
	}

	@Override
	public Result valiate(String type, String value) {
		// TODO Auto-generated method stub
		String typeText = "";
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		if (type.equals("phone")) {
			typeText = "电话号码";
			criteria.andUserPhoneEqualTo(value);
		} else if (type.equals("email")) {
			typeText = "邮箱";
			criteria.andUserEmailEqualTo(value);
		}
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() <= 0) {
			return Result.success();
		} else {
			return Result.failure(ResultCode.FAIL, "此" + typeText + "已被注册过，请重新输入");
		}
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		int num = userMapper.updateByPrimaryKeySelective(user);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}
}