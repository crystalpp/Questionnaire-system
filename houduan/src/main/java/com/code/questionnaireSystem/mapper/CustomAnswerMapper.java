package com.code.questionnaireSystem.mapper;

import java.util.List;
import java.util.Map;

import com.code.questionnaireSystem.pojo.AnswerStatic;

public interface CustomAnswerMapper {
	List<AnswerStatic> getAnswerText(String surverId);

	List<AnswerStatic> getQuestionOption(String surverId);

	List<AnswerStatic> getSubQuestionOption(Map<String, Object> map);

}
