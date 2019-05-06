package com.code.questionnaireSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.QuestionService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@PostMapping("/add")
	public Result add(String title, String subdesc, String type, Boolean required, List<String> options) {
		return questionService.add(title, subdesc, type, required, options);
	}
}
