package com.code.questionnaireSystem.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.code.questionnaireSystem.pojo.User;

@Mapper
public interface CustomUserMapper {

	User login(User user);

}
