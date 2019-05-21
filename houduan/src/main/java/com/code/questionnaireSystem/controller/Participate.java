package com.code.questionnaireSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.ParticipateService;
import com.code.questionnaireSystem.utils.Result;

/**
 * 参与者（被调查者）controller层
 * 
 * @author 皮艳萍
 *
 */
@RestController
@RequestMapping("/participate")
public class Participate {
	@Autowired
	private ParticipateService participateService;

	@GetMapping("/getDeviceType")
	public Result getDeviceType(HttpServletRequest request) {
		return participateService.getDeviceType(request);

	}

	@GetMapping("/getIp")
	public Result getIp(HttpServletRequest request) {
		return participateService.getIp(request);
	}

	@GetMapping("/getAddress")
	public Result getAddress(HttpServletRequest request) {
		return participateService.getAddress(request);
	}
}
