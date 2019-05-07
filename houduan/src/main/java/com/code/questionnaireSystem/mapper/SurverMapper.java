package com.code.questionnaireSystem.mapper;

import com.code.questionnaireSystem.pojo.Surver;
import com.code.questionnaireSystem.pojo.SurverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurverMapper {
    int countByExample(SurverExample example);

    int deleteByExample(SurverExample example);

    int deleteByPrimaryKey(String surverId);

    int insert(Surver record);

    int insertSelective(Surver record);

    List<Surver> selectByExample(SurverExample example);

    Surver selectByPrimaryKey(String surverId);

    int updateByExampleSelective(@Param("record") Surver record, @Param("example") SurverExample example);

    int updateByExample(@Param("record") Surver record, @Param("example") SurverExample example);

    int updateByPrimaryKeySelective(Surver record);

    int updateByPrimaryKey(Surver record);
}