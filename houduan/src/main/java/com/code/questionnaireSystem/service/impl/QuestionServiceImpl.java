package com.code.questionnaireSystem.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.QuestionMapper;
import com.code.questionnaireSystem.mapper.QuestionOptionMapper;
import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.pojo.QuestionOption;
import com.code.questionnaireSystem.service.QuestionService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionOptionMapper optionMapper;

	@Override
	public Result add(String title, String subdesc, String type, String required, String options) {
		// TODO Auto-generated method stub
		// List<String> optionsList = new ArrayList<>();
		String[] optionsList = options.split(",");
		int selectInsert = 0;
		String quesId = UUID.randomUUID().toString().substring(0, 10);
		Question question = new Question(quesId, title, subdesc, required, type, "1");
		int num = questionMapper.insertSelective(question);
		for (String option : optionsList) {
			String optionId = UUID.randomUUID().toString().substring(0, 10);
			QuestionOption o = new QuestionOption(optionId, option, "0", quesId);
			selectInsert = optionMapper.insert(o);
		}
		if (selectInsert >= 1 && num >= 1) {
			return Result.success();
		} else {
			return Result.failure(ResultCode.FAIL);
		}
	}

}
