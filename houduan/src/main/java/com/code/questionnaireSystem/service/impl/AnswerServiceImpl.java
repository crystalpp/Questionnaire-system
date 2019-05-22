package com.code.questionnaireSystem.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.AnswerMapper;
import com.code.questionnaireSystem.pojo.Answer;
import com.code.questionnaireSystem.service.AnswerService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class AnswerServiceImpl implements AnswerService {

	private AnswerMapper answerMapper;

	@Override
	public Result add(String surverId, String questionId, String subQuestionId, String optionId, String participateId) {
		Answer answer = new Answer();
		String id = UUID.randomUUID().toString().substring(0, 10);
		answer.setAnswerId(id);
		answer.setSurverId(surverId);
		answer.setQuestionId(questionId);
		answer.setSubquestionId(subQuestionId);
		answer.setOptionId(optionId);
		answer.setParticipateId(participateId);
		int num = answerMapper.insertSelective(answer);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}

	}

}
