package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.utils.Result;

public interface SurverService {

	Result insert(String userId, String surverTypeId);

	Result update(String title, String description, String id);

	Result search(String surverId);

	Result seachByUserId(String userId);

	Result deleteById(String surverId);

	Result updateEndTime(String surverId, String endTime, int limitIP);

	Result selectSurvers(String surverTypeId, String surverTitle);

	Result getTemplate(String surverTypeId);

	Result updateSurverType(String surverId, String surverTypeId);

	Result updateRecoverNum(String surerId);

	Result creatByTemplate(String templateSurverId, String userId);

}
