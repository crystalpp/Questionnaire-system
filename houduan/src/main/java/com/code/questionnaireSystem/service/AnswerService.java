package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.utils.Result;

public interface AnswerService {

	Result add(String surverId, String questionId, String subQuestionId, String optionId, String participateId);

}
