package com.code.questionnaireSystem.service;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.code.questionnaireSystem.utils.Result;

public interface ParticipateService {

	Result getDeviceType(HttpServletRequest request);

	Result getIp(HttpServletRequest request);

	Result getAddress(HttpServletRequest request) throws Exception;

	Result getAll(String surverId);

	Result addNewParticipate(String ip, String address, String device, String surverId, String participateId);

	Result updateEndTime(String participateId);

	Result selectParticiByTime(String startTime, String endTime, String surverId);

	Result getAllByPage(String surverId, Integer pageNum, Integer pageSize);

	Result add(String ip, String device, String area, String surverId, String startTime, String endTime)
			throws ParseException;

}
