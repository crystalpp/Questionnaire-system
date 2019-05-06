package com.code.questionnaireSystem.service;

import java.util.List;

import com.code.questionnaireSystem.utils.Result;

public interface QuestionService {

	Result add(String title, String subdesc, String type, Boolean required, List<String> options);

}
