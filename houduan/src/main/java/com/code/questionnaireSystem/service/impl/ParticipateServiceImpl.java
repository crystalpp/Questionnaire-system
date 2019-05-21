package com.code.questionnaireSystem.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.service.ParticipateService;
import com.code.questionnaireSystem.utils.GeoUtil;
import com.code.questionnaireSystem.utils.IpUtils;
import com.code.questionnaireSystem.utils.Result;
import com.maxmind.geoip2.model.CityResponse;

@Service
public class ParticipateServiceImpl implements ParticipateService {

	@Override
	public Result getDeviceType(HttpServletRequest request) {
		String requestHeader = request.getHeader("user-agent");
		requestHeader = requestHeader.toLowerCase();
		return Result.success(requestHeader);
	}

	@Override
	public Result getIp(HttpServletRequest request) {
		String ip = IpUtils.getIpAddr(request);
		return Result.success(ip);
	}

	@Override
	public Result getAddress(HttpServletRequest request) throws Exception {
		String ip = IpUtils.getIpAddr(request);
		CityResponse respons = GeoUtil.getResponse(ip);
		String province = GeoUtil.Geoprovince(respons).getNames().get("zh-CN");
		return Result.success(province);

	}

}
