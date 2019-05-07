package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.SurverService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/surver")
public class SurverController {
	@Autowired
	private SurverService surverService;

	@PostMapping("/add")
	public Result insert(String userId) {
		return surverService.insert(userId);
	}

	@PostMapping("/update")

	public Result update(String title, String description, String id) {
		return surverService.update(title, description, id);
	}

}
