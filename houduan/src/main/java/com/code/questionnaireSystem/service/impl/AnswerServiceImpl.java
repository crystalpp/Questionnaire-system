package com.code.questionnaireSystem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.AnswerMapper;
import com.code.questionnaireSystem.mapper.CustomAnswerMapper;
import com.code.questionnaireSystem.mapper.QuestionMapper;
import com.code.questionnaireSystem.mapper.QuestionOptionMapper;
import com.code.questionnaireSystem.pojo.Answer;
import com.code.questionnaireSystem.pojo.AnswerExample;
import com.code.questionnaireSystem.pojo.AnswerStatic;
import com.code.questionnaireSystem.pojo.AnswerStaticAll;
import com.code.questionnaireSystem.pojo.OptionNum;
import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.pojo.QuestionExample;
import com.code.questionnaireSystem.pojo.QuestionOption;
import com.code.questionnaireSystem.pojo.QuestionOptionExample;
import com.code.questionnaireSystem.pojo.SubQuestion;
import com.code.questionnaireSystem.pojo.SubQuestionAnswer;
import com.code.questionnaireSystem.service.AnswerService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerMapper answerMapper;
	@Autowired
	private CustomAnswerMapper customAnswerMapper;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionOptionMapper questionOptionMapper;

	@Override
	public Result add(String surverId, String questionId, String subQuestionId, String optionId, String answerText,
			String participateId) {
		Answer answer = new Answer();
		String id = UUID.randomUUID().toString().substring(0, 10);
		answer.setAnswerId(id);
		answer.setSurverId(surverId);
		answer.setQuestionId(questionId);
		if (subQuestionId != null) {
			answer.setSubquestionId(subQuestionId);
		}
		if (optionId != null) {
			answer.setOptionId(optionId);
		}
		answer.setParticipateId(participateId);
		if (answerText != null) {
			answer.setAnswertext(answerText);
		}

		int num = answerMapper.insertSelective(answer);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}

	}

	@Override
	public Result getAnswersBySurverId(String surverId) {
		// TODO Auto-generated method stub
		AnswerExample answerExample = new AnswerExample();
		AnswerExample.Criteria criteria = answerExample.createCriteria();
		criteria.andSurverIdEqualTo(surverId);
		List<Answer> answers = answerMapper.selectByExample(answerExample);
		return Result.success(answers);
	}

	@Override
	public Result staticAnswerText(String surverId) {
		// TODO Auto-generated method stub
		List<AnswerStatic> answerStatics = new ArrayList<>();
		List<AnswerStatic> answerStatics2 = new ArrayList<>();
		List<AnswerStaticAll> answerStatics3 = new ArrayList<>();
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andSurverIdEqualTo(surverId);
		List<SubQuestion> subQuestionsAnswer = new ArrayList<>();
		List<Question> questions = questionMapper.selectByExample(questionExample);
		for (Question q : questions) {
			if (q.getSubquestionId().equals("")) {
				answerStatics = customAnswerMapper.getAnswerText(surverId);
				answerStatics2 = customAnswerMapper.getQuestionOption(surverId);
			} else {
				SubQuestionAnswer subQuestionAnswer = new SubQuestionAnswer();
				subQuestionAnswer.setQuestionId(q.getQuestionId());
				subQuestionAnswer.setQuestionName(q.getQuestionName());
				// 根据questionId 查询option的信息
				QuestionOptionExample questionOptionExample = new QuestionOptionExample();
				QuestionOptionExample.Criteria criteriaOption = questionOptionExample.createCriteria();
				criteriaOption.andQuestionIdEqualTo(q.getQuestionId());
				List<QuestionOption> options = questionOptionMapper.selectByExample(questionOptionExample);

				String[] sbQuestionsList = q.getSubquestionId().split(",");
				// 根据subquestionId 查询所有question的具体信息

				for (String sbQuestion : sbQuestionsList) {
					Question subQuestions = questionMapper.selectByPrimaryKey(sbQuestion);

					SubQuestion subQuestion = new SubQuestion();

					List<OptionNum> optionNums = new ArrayList<>();
					for (QuestionOption qo : options) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("optionId", qo.getOptionId());
						map.put("subQuestion_id", subQuestions.getQuestionId());
						int count = customAnswerMapper.countSubQuestionOption(map);
						OptionNum optionNum = new OptionNum();
						optionNum.setNum(count);
						optionNum.setQOption(qo);
						optionNums.add(optionNum);
					}
					subQuestion.setOptionNums(optionNums);
					subQuestion.setSubQuestion_id(subQuestions.getQuestionId());
					subQuestion.setSub_QuestionName(subQuestions.getQuestionName());
					subQuestionsAnswer.add(subQuestion);

				}

				// Map<String, Object> map = new HashMap<String, Object>();
				// map.put("surverId", surverId);
				// map.put("questionId", q.getQuestionId());
				// AnswerStaticAll aStaticAll = new AnswerStaticAll();
				// aStaticAll.setQuestionId(q.getQuestionId());
				// aStaticAll.setQuestionName(q.getQuestionName());
				// aStaticAll.setAnswerStatics(customAnswerMapper.getSubQuestionOption(map));
				// answerStatics3.add(aStaticAll);

			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("type1", answerStatics);
		resultMap.put("type2", answerStatics2);
		resultMap.put("type3", subQuestionsAnswer);
		// answerStatics.addAll(answerStatics2);
		// answerStatics.addAll(answerStatics3);
		return Result.success(resultMap);
	}

	@Override
	public Result getAnswersByParticipateId(String participateId) {
		// TODO Auto-generated method stub
		AnswerExample answerExample = new AnswerExample();
		AnswerExample.Criteria criteria = answerExample.createCriteria();
		criteria.andParticipateIdEqualTo(participateId);
		List<Answer> answers = answerMapper.selectByExample(answerExample);
		return Result.success(answers);
	}

}
