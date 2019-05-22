package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.AnswerService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/answer")
public class Answer {
	@Autowired
	private AnswerService answerService;

	@PostMapping("/add")
	public Result add(String surverId, String questionId,
			@RequestParam(name = "subQuestionId", required = false) String subQuestionId,
			@RequestParam(name = "optionId", required = false) String optionId,
			@RequestParam(name = "answerText", required = false) String answerText, String participateId) {
		return answerService.add(surverId, questionId, subQuestionId, optionId, participateId);
	}

}
