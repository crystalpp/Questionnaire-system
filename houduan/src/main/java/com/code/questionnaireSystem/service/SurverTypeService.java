package com.code.questionnaireSystem.service;

import com.code.questionnaireSystem.utils.Result;

public interface SurverTypeService {

	Result delete(String id);

	Result add(String name, String userId);

	Result getAll(String userId);

}
