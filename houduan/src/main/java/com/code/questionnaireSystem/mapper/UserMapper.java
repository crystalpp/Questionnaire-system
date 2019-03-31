package com.code.questionnaireSystem.mapper;

import com.code.questionnaireSystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
   List<User> queryAllUsers();

}
