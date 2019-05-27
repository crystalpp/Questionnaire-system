package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.utils.Result;

public interface AnswerService {

	Result add(String surverId, String questionId, String subQuestionId, String optionId, String participateId,
			String participateId2);

	Result getAnswersBySurverId(String surverId);

	Result staticAnswerText(String surverId);

	Result getAnswersByParticipateId(String participateId, String surverId);

	Result countAnswerNum(String surverId);

	Result deleteAnswer(String participateId, String surverId);

}
