package com.code.questionnaireSystem.mapper;

import com.code.questionnaireSystem.pojo.Participate;
import com.code.questionnaireSystem.pojo.ParticipateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipateMapper {
    int countByExample(ParticipateExample example);

    int deleteByExample(ParticipateExample example);

    int deleteByPrimaryKey(String participateId);

    int insert(Participate record);

    int insertSelective(Participate record);

    List<Participate> selectByExample(ParticipateExample example);

    Participate selectByPrimaryKey(String participateId);

    int updateByExampleSelective(@Param("record") Participate record, @Param("example") ParticipateExample example);

    int updateByExample(@Param("record") Participate record, @Param("example") ParticipateExample example);

    int updateByPrimaryKeySelective(Participate record);

    int updateByPrimaryKey(Participate record);
}