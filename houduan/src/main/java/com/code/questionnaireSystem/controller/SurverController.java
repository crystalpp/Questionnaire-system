package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.SurverService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/surver")
public class SurverController {
	@Autowired
	private SurverService surverService;

	@GetMapping("/insertQues")
	public Result insert() {
		return surverService.insert();
	}

}
