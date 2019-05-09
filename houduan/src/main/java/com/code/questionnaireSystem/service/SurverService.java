package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.utils.Result;

public interface SurverService {

	Result insert(String userId);

	Result update(String title, String description, String id);

	Result search(String surverId);

	Result seachByUserId(String userId);

	Result deleteById(String surverId);

}