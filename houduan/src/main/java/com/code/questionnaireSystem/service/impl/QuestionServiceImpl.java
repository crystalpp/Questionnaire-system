package com.code.questionnaireSystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.QuestionMapper;
import com.code.questionnaireSystem.mapper.QuestionOptionMapper;
import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.pojo.QuestionExample;
import com.code.questionnaireSystem.pojo.QuestionOption;
import com.code.questionnaireSystem.pojo.QuestionOptionExample;
import com.code.questionnaireSystem.pojo.QuestionsResult;
import com.code.questionnaireSystem.service.QuestionService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionOptionMapper questionoptionMapper;

	@Override
	public Result add(String title, String subdesc, String type, String required, String options, String surverId,
			String questions) {
		// TODO Auto-generated method stub
		Question question = new Question();
		String subQuesionIds = "";
		if (questions != null) {
			String[] questionsList = questions.split(",");
			for (String q : questionsList) {
				String subQuesId = UUID.randomUUID().toString().substring(0, 10);
				subQuesionIds += subQuesId;
				subQuesionIds += ",";
				question.setQuestionId(subQuesId);
				question.setQuestionName(q);
				question.setQuestionNeed(required);
				question.setQuetypeId(type);
				int subQuestionNum = questionMapper.insertSelective(question);
				if (subQuestionNum < 1) {
					return Result.failure(ResultCode.FAIL);
				}
			}

		}
		int selectInsert = 0;
		String quesId = UUID.randomUUID().toString().substring(0, 10);
		question.setQuestionId(quesId);
		question.setQuestionName(title);
		question.setQuestionDirection(subdesc);
		question.setQuestionNeed(required);
		question.setQuetypeId(type);
		question.setSurverId(surverId);
		question.setSubquestionId(subQuesionIds);
		int num = questionMapper.insertSelective(question);
		if (options != null) {
			String[] optionsList = options.split(",");
			for (String option : optionsList) {
				String optionId = UUID.randomUUID().toString().substring(0, 10);
				QuestionOption qo = new QuestionOption();
				qo.setOptionId(optionId);
				qo.setOptionContent(option);
				qo.setOptionScore("0");
				qo.setQuestionId(quesId);
				qo.setSubquestionId(subQuesionIds);
				selectInsert = questionoptionMapper.insertSelective(qo);
				if (selectInsert < 1) {
					return Result.failure(ResultCode.FAIL);
				}
			}
		}
		if (num >= 1) {
			return Result.success();
		} else {
			return Result.failure(ResultCode.FAIL);
		}
	}

	/**
	 * 根据问卷id查询所有已经设计的问题
	 */
	@Override
	public Result searchBySurverId(String surverId) {
		// TODO Auto-generated method stub
		List<QuestionsResult> questionsResults = new ArrayList<>();
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andSurverIdEqualTo(surverId);
		List<Question> questions = questionMapper.selectByExample(questionExample);
		for (Question q : questions) {
			QuestionsResult questionResult = new QuestionsResult();
			questionResult.setQuestionId(q.getQuestionId());
			questionResult.setQuestionDirection(q.getQuestionDirection());
			questionResult.setQuestionName(q.getQuestionName());
			questionResult.setQuestionNeed(q.getQuestionNeed());
			questionResult.setQuetypeId(q.getQuetypeId());
			questionResult.setSurverId(q.getSurverId());
			QuestionOptionExample qOExample = new QuestionOptionExample();
			QuestionOptionExample.Criteria qoCriteria = qOExample.createCriteria();
			qoCriteria.andQuestionIdEqualTo(q.getQuestionId());
			List<QuestionOption> qOptions = questionoptionMapper.selectByExample(qOExample);
			questionResult.setOptions(qOptions);
			if (!q.getSubquestionId().equals("")) {

				String[] subQuestionIds = q.getSubquestionId().split(",");
				List<Question> subQuestions = new ArrayList<>();
				for (String subQuesId : subQuestionIds) {
					QuestionExample subQExample = new QuestionExample();
					QuestionExample.Criteria subQCriteria1 = subQExample.createCriteria();
					subQCriteria1.andQuestionIdEqualTo(subQuesId);
					List<Question> subQuestion = questionMapper.selectByExample(subQExample);
					System.out.println(subQuestion.get(0).getQuestionName());
					subQuestions.add(subQuestion.get(0));
				}

				questionResult.setSubQuestions(subQuestions);
			} else {
				questionResult.setSubQuestions(null);
			}
			questionsResults.add(questionResult);
		}
		return Result.success(questionsResults);
	}

}
