package com.code.questionnaireSystem.mapper;

import java.util.List;
import java.util.Map;

import com.code.questionnaireSystem.pojo.ParticipateAnswer;

public interface CustomParticipateAnswerMapper {
	List<ParticipateAnswer> getParticiPateAnswer(Map<String, Object> map);
}
