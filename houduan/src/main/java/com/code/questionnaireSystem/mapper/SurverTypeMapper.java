package com.code.questionnaireSystem.mapper;

import com.code.questionnaireSystem.pojo.SurverType;
import com.code.questionnaireSystem.pojo.SurverTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurverTypeMapper {
    int countByExample(SurverTypeExample example);

    int deleteByExample(SurverTypeExample example);

    int deleteByPrimaryKey(String survertypeId);

    int insert(SurverType record);

    int insertSelective(SurverType record);

    List<SurverType> selectByExample(SurverTypeExample example);

    SurverType selectByPrimaryKey(String survertypeId);

    int updateByExampleSelective(@Param("record") SurverType record, @Param("example") SurverTypeExample example);

    int updateByExample(@Param("record") SurverType record, @Param("example") SurverTypeExample example);

    int updateByPrimaryKeySelective(SurverType record);

    int updateByPrimaryKey(SurverType record);
}