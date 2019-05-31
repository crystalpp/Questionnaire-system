package com.code.questionnaireSystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.ParticipateMapper;
import com.code.questionnaireSystem.mapper.SurverMapper;
import com.code.questionnaireSystem.pojo.Participate;
import com.code.questionnaireSystem.pojo.ParticipateExample;
import com.code.questionnaireSystem.pojo.Surver;
import com.code.questionnaireSystem.service.ParticipateService;
import com.code.questionnaireSystem.utils.GeoUtil;
import com.code.questionnaireSystem.utils.IpUtils;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxmind.geoip2.model.CityResponse;

import eu.bitwalker.useragentutils.UserAgent;

@Service
public class ParticipateServiceImpl implements ParticipateService {
	@Autowired
	private ParticipateMapper participateMapper;
	@Autowired
	private SurverMapper surverMapper;

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
		// "113.65.161.209"
		CityResponse respons = GeoUtil.getResponse(ip);
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

	public Result addNew(String ip, String address, String device, String surverId) {
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
	public Result addNewParticipate(String ip, String address, String device, String surverId, String participateId) {
		// 查找出该问卷的所有填写者的信息
		ParticipateExample participateExample = new ParticipateExample();
		ParticipateExample.Criteria criteria = participateExample.createCriteria();
		criteria.andParticipateSurveridEqualTo(surverId);
		List<Participate> participateList = participateMapper.selectByExample(participateExample);
		Surver surver = surverMapper.selectByPrimaryKey(surverId);
		boolean ipFlag = false;
		boolean participateFlag = false;
		for (Participate participate : participateList) {
			if (participate.getParticipateIp().equals(ip)) {
				ipFlag = true;
				break;
			}
		}
		for (Participate participate : participateList) {
			if (participate.getParticipateId().equals(participateId)) {
				participateFlag = true;
				break;
			}
		}
		if (participateFlag) {
			Participate participate1 = participateMapper.selectByPrimaryKey(participateId);
			if (participate1.getParticipateEndtime() != null) {
				if (surver.getSurverLimitip() == 1) {
					if (ipFlag) {
						return Result.success(ResultCode.FILLED);
					} else {
						Result result = addNew(ip, address, device, surverId);
						return result;
					}
				} else {
					Result result = addNew(ip, address, device, surverId);
					return result;
				}
			} else {
				// Result result = addNew(ip, address, device, surverId);
				return Result.success(participateId);
			}
		} else {
			Result result = addNew(ip, address, device, surverId);
			return result;
		}
		// String id = ""
	}

	/**
	 * 更新参与者表的结束时间
	 */
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
	public Result selectParticiByTime(String startTime, String endTime, String surverId) {
		// TODO Auto-generated method stub
		ParticipateExample example = new ParticipateExample();
		ParticipateExample.Criteria criteria = example.createCriteria();
		Date startDate = null;
		Date endDate = null;
		startTime = startTime.replace("Z", " UTC");// 注意是空格+UTC
		endTime = endTime.replace("Z", " UTC");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");// 注意格式化的表达式
		try {
			startDate = format.parse(startTime);
			endDate = format.parse(endTime);
			// 多加一天
			endDate.setDate(endDate.getDate() + 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		criteria.andParticipateEndtimeGreaterThanOrEqualTo(startDate);
		criteria.andParticipateEndtimeLessThanOrEqualTo(endDate);
		// criteria.andParticipateEndtimeBetween(startDate, endDate);
		criteria.andParticipateSurveridEqualTo(surverId);
		List<Participate> participates = participateMapper.selectByExample(example);
		return Result.success(participates);
	}

	@Override
	public Result getAllByPage(String surverId, Integer pageNum, Integer pageSize) {
		ParticipateExample participateExample = new ParticipateExample();
		ParticipateExample.Criteria criteria = participateExample.createCriteria();
		criteria.andParticipateSurveridEqualTo(surverId);
		criteria.andParticipateEndtimeIsNotNull();
		PageHelper.startPage(pageNum, pageSize);
		List<Participate> participates = participateMapper.selectByExample(participateExample);
		PageInfo<Participate> participatePageInfo = new PageInfo<>(participates);
		// 得到分页中的person条目对象
		// List<Participate> pageList = participatePageInfo.getList();
		return Result.success(participatePageInfo);
	}
}
