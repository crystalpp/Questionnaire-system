package com.code.questionnaireSystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.SurverMapper;
import com.code.questionnaireSystem.pojo.Surver;
import com.code.questionnaireSystem.pojo.SurverExample;
import com.code.questionnaireSystem.service.SurverService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class SurverServiceImpl implements SurverService {
	@Autowired
	private SurverMapper surverMapper;

	@Override
	public Result insert(String userId) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString().substring(0, 10);
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date createTime = new Date();
		Surver surver = new Surver();
		surver.setSurverCreattime(createTime);
		surver.setSurverId(id);
		surver.setUserId(userId);
		surver.setSurverTitle("问卷标题");
		surver.setSurverDescription("感谢您能抽出几分钟时间来参加本次答题，现在我们就马上开始吧!");
		int num = surverMapper.insertSelective(surver);
		if (num >= 1) {
			return Result.success(surver);
		} else {
			return Result.failure(ResultCode.FAIL);
		}
	}

	@Override
	public Result update(String title, String description, String id) {
		// TODO Auto-generated method stub
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		criteria.andSurverIdEqualTo(id);
		Surver surver = new Surver();
		surver.setSurverTitle(title);
		surver.setSurverDescription(description);
		int num = surverMapper.updateByExampleSelective(surver, surverExample);
		if (num >= 1) {
			return Result.success();
		} else {
			return Result.failure(ResultCode.FAIL);
		}

	}

	@Override
	public Result search(String surverId) {
		// TODO Auto-generated method stub
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		criteria.andSurverIdEqualTo(surverId);
		List<Surver> survers = surverMapper.selectByExample(surverExample);
		return Result.success(survers);
	}

	@Override
	public Result seachByUserId(String userId) {
		// TODO Auto-generated method stub
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Surver> survers = surverMapper.selectByExample(surverExample);
		return Result.success(survers);
	}

	@Override
	public Result deleteById(String surverId) {
		// TODO Auto-generated method stub
		// 在surver表中删除问卷
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		criteria.andSurverIdEqualTo(surverId);
		int num = surverMapper.deleteByExample(surverExample);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}

	/**
	 * 更新问卷的发布截止时间，是否限制ip等字段
	 */
	@Override
	public Result updateEndTime(String surverId, String endTime, int limitIP) {
		// TODO Auto-generated method stub
		Date d = null;
		endTime = endTime.replace("Z", " UTC");// 注意是空格+UTC
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");// 注意格式化的表达式
		try {
			d = format.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		criteria.andSurverIdEqualTo(surverId);
		Surver surver = new Surver();
		surver.setSurverId(surverId);
		surver.setSurverPulishstarttime(new Date());
		surver.setSurverEndtime(d);
		surver.setSurverLimitip(limitIP);
		int num = surverMapper.updateByPrimaryKeySelective(surver);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}
}
