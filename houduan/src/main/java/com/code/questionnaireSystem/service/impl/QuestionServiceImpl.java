package com.code.questionnaireSystem.service.impl;

import java.util.List;
import java.util.UUID;

import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.service.QuestionService;
import com.code.questionnaireSystem.utils.Result;

public class QuestionServiceImpl implements QuestionService {
	@Override
	public Result add(String title, String subdesc, String type, Boolean required, List<String> options) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString().substring(0, 10);
		Question question = new Question(id, title, subdesc, required, quetypeId, surverId)
		return null;
	}

}
