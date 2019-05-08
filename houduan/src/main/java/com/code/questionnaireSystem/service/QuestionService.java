package com.code.questionnaireSystem.service;

import java.util.List;

import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.response.QuestionResponse;
import com.code.questionnaireSystem.utils.Result;

public interface QuestionService {

	Result add(String title, String subdesc, String type, String required, String options, String surverId,
			String questions);

	Result searchBySurverId(String surverId);

	Result deleteBySurverId(String surverId);

	Result deleteByQuestionId(String questionId);

	Result deleteQuestionAndOption(List<Question> qList);

	Result updateByQuestionId(QuestionResponse questionResponse);

}
