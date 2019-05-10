package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.SurverTypeService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/surverType")
public class SurverTypeController {
	@Autowired
	private SurverTypeService surverTypeService;

	/**
	 * 删除某种问卷类型，就是将问卷类型的isDelete标志位置为1
	 */
	@PostMapping("/delete")
	public Result delete(String id) {
		return surverTypeService.delete(id);
	}

	@PostMapping("/add")
	public Result add(String name, String userId) {
		return surverTypeService.add(name, userId);
	}

	@GetMapping("/getAll")
	public Result add(String userId) {
		return surverTypeService.getAll(userId);
	}

}
