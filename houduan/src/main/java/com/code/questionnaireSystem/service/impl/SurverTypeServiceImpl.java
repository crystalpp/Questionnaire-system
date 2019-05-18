package com.code.questionnaireSystem.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.SurverTypeMapper;
import com.code.questionnaireSystem.pojo.SurverType;
import com.code.questionnaireSystem.pojo.SurverTypeExample;
import com.code.questionnaireSystem.service.SurverTypeService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class SurverTypeServiceImpl implements SurverTypeService {
	@Autowired
	private SurverTypeMapper surverTypeMapper;

	@Override
	public Result delete(String id) {

		// TODO Auto-generated method stub
		SurverType surverType = new SurverType();
		surverType.setSurvertypeId(id);
		surverType.setSurvertypeIsdelete(1);
		int num = surverTypeMapper.updateByPrimaryKey(surverType);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}

	}

	@Override
	public Result add(String name, String userId) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString().substring(0, 10);
		SurverType surverType = new SurverType();
		surverType.setSurvertypeId(id);
		surverType.setSurvertypeName(name);
		surverType.setSurvertypeIsdelete(0);
		surverType.setUserId(userId);
		int num = surverTypeMapper.insertSelective(surverType);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}

	@Override
	public Result getAll(String userId) {
		// TODO Auto-generated method stub
		SurverTypeExample surverTypeExample = new SurverTypeExample();
		SurverTypeExample.Criteria criteria = surverTypeExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andSurvertypeIsdeleteEqualTo(0);
		List<SurverType> surverTypes = surverTypeMapper.selectByExample(surverTypeExample);
		return Result.success(surverTypes);
	}

	@Override
	public Result selectById(String id) {
		// TODO Auto-generated method stub
		SurverTypeExample surverTypeExample = new SurverTypeExample();
		SurverTypeExample.Criteria criteria = surverTypeExample.createCriteria();
		criteria.andSurvertypeIdEqualTo(id);
		List<SurverType> surverTypes = surverTypeMapper.selectByExample(surverTypeExample);
		return Result.success(surverTypes);
	}

	@Override
	public Result selectTemplate() {
		SurverTypeExample surverTypeExample = new SurverTypeExample();
		SurverTypeExample.Criteria criteria = surverTypeExample.createCriteria();
		criteria.andSurvertypeIstemplateEqualTo(1);
		List<SurverType> surverTypes = surverTypeMapper.selectByExample(surverTypeExample);
		return Result.success(surverTypes);
	}

}
