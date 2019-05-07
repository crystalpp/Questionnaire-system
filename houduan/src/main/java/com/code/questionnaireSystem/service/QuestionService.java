package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.utils.Result;

public interface QuestionService {

	Result add(String title, String subdesc, String type, String required, String options, String surverId,
			String questions);

	Result searchBySurverId(String surverId);

}
