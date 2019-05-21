package com.code.questionnaireSystem.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Result getAddress(HttpServletRequest request) throws Exception {
		return participateService.getAddress(request);
	}

	@GetMapping("/getAll")
	public Result getAll(String surverId) {
		return participateService.getAll(surverId);
	}

	@PostMapping("/addNewParticipate")
	public Result addNewParticipate(String ip, String address, String device, String surverId) {
		return participateService.addNewParticipate(ip, address, device, surverId);
	}

	@PostMapping("/updateEndTime")
	public Result updateEndTime(String participateId) {
		return participateService.updateEndTime(participateId);
	}

	@GetMapping("/selectParticiByTime")
	public Result selectParticiByTime(Date startTime, Date endTime, String surverId) {
		return participateService.selectParticiByTime(startTime, endTime, surverId);
	}

}
