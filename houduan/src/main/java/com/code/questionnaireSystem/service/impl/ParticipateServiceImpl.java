package com.code.questionnaireSystem.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.service.ParticipateService;
import com.code.questionnaireSystem.utils.Result;

@Service
public class ParticipateServiceImpl implements ParticipateService {

	@Override
	public Result getDeviceType(HttpServletRequest request) {
		String requestHeader = request.getHeader("user-agent");
		requestHeader = requestHeader.toLowerCase();
		return Result.success(requestHeader);
	}

}
