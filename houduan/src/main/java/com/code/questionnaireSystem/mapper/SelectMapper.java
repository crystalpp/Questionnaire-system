package com.code.questionnaireSystem.mapper;

import com.code.questionnaireSystem.pojo.Select;
import com.code.questionnaireSystem.pojo.SelectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectMapper {
    int countByExample(SelectExample example);

    int deleteByExample(SelectExample example);

    int deleteByPrimaryKey(Integer selectId);

    int insert(Select record);

    int insertSelective(Select record);

    List<Select> selectByExample(SelectExample example);

    Select selectByPrimaryKey(Integer selectId);

    int updateByExampleSelective(@Param("record") Select record, @Param("example") SelectExample example);

    int updateByExample(@Param("record") Select record, @Param("example") SelectExample example);

    int updateByPrimaryKeySelective(Select record);

    int updateByPrimaryKey(Select record);
}