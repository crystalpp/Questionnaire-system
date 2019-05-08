package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.response.QuestionResponse;
import com.code.questionnaireSystem.service.QuestionService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@PostMapping("/add")
	public Result add(String title, String subdesc, String type, String required, String options, String surverId,
			String questions) {
		return questionService.add(title, subdesc, type, required, options, surverId, questions);
	}

	@GetMapping("/searchBySurverId")
	public Result searchBySurverId(String surverId) {
		return questionService.searchBySurverId(surverId);
	}

	@PostMapping("/deleteBySurverId")
	public Result deleteBySurverId(String surverId) {
		return questionService.deleteBySurverId(surverId);
	}

	@PostMapping("/deleteByQuestionId")
	public Result deleteByQuestioId(String questionId) {
		return questionService.deleteByQuestionId(questionId);
	}

	@PostMapping("/updateByQuestionId")
	@ResponseBody
	public Result updateByQuestionId(@RequestBody QuestionResponse questionResponse) {
		return questionService.updateByQuestionId(questionResponse);
	}
}
