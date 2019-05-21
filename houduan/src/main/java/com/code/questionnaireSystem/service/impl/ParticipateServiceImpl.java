package com.code.questionnaireSystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.ParticipateMapper;
import com.code.questionnaireSystem.pojo.Participate;
import com.code.questionnaireSystem.pojo.ParticipateExample;
import com.code.questionnaireSystem.service.ParticipateService;
import com.code.questionnaireSystem.utils.GeoUtil;
import com.code.questionnaireSystem.utils.IpUtils;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;
import com.maxmind.geoip2.model.CityResponse;

import eu.bitwalker.useragentutils.UserAgent;

@Service
public class ParticipateServiceImpl implements ParticipateService {
	@Autowired
	private ParticipateMapper participateMapper;

	@Override
	public Result getDeviceType(HttpServletRequest request) {
		String requestHeader = request.getHeader("user-agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(requestHeader);
		// requestHeader = requestHeader.toLowerCase();
		return Result.success(userAgent.getBrowser().toString());
	}

	@Override
	public Result getIp(HttpServletRequest request) {
		String ip = IpUtils.getIpAddr(request);
		return Result.success(ip);
	}

	@Override
	public Result getAddress(HttpServletRequest request) throws Exception {
		String ip = IpUtils.getIpAddr(request);
		CityResponse respons = GeoUtil.getResponse("113.65.161.209");
		String province = GeoUtil.Geoprovince(respons).getNames().get("zh-CN");
		return Result.success(province);

	}

	@Override
	public Result getAll(String surverId) {
		// TODO Auto-generated method stub
		ParticipateExample participateExample = new ParticipateExample();
		ParticipateExample.Criteria criteria = participateExample.createCriteria();
		criteria.andParticipateSurveridEqualTo(surverId);
		List<Participate> participates = participateMapper.selectByExample(participateExample);
		return Result.success(participates);
	}

	@Override
	public Result addNewParticipate(String ip, String address, String device, String surverId) {
		String id = UUID.randomUUID().toString().substring(0, 10);
		Participate participate = new Participate();
		participate.setParticipateId(id);
		participate.setParticipateIp(ip);
		participate.setParticipateDevice(device);
		participate.setParticipateArea(address);
		participate.setParticipateSurverid(surverId);
		participate.setParticipateStarttime(new Date());
		int num = participateMapper.insertSelective(participate);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success(id);
		}
	}

	@Override
	public Result updateEndTime(String participateId) {
		Participate participate = new Participate();
		participate.setParticipateId(participateId);
		participate.setParticipateEndtime(new Date());
		int num = participateMapper.updateByPrimaryKeySelective(participate);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}

	@Override
	public Result selectParticiByTime(Date startTime, Date endTime, String surverId) {
		// TODO Auto-generated method stub
		ParticipateExample example = new ParticipateExample();
		ParticipateExample.Criteria criteria = example.createCriteria();
		criteria.andParticipateEndtimeBetween(startTime, endTime);
		criteria.andParticipateSurveridEqualTo(surverId);
		List<Participate> participates = participateMapper.selectByExample(example);
		return Result.success(participates);
	}
}
