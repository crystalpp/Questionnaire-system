
package com.code.questionnaireSystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.code.questionnaireSystem.response.QuestionResponse;
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
		question.setQuestionCreattime(new Date());
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
		questionExample.setOrderByClause("question_creatTime ASC");
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
					// System.out.println(subQuestion.get(0).getQuestionName());
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

	@Override
	public Result deleteBySurverId(String surverId) {
		// 查找问题表中属于该问卷的所有问题
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria qCriteria = questionExample.createCriteria();
		qCriteria.andSurverIdEqualTo(surverId);
		// 按照surverid查询出所有的问题，判断其是否有副问题，如果有，将副问题也删除
		List<Question> qList = questionMapper.selectByExample(questionExample);
		if (qList.size() != 0) {
			Result result = deleteQuestionAndOption(qList);
			int num = questionMapper.deleteByExample(questionExample);
			if (num < 1) {
				return Result.failure(ResultCode.FAIL);
			} else {
				return Result.success();
			}
		}
		return Result.success();
	}

	/**
	 * 删除问题和问题选项 不涉及前端接口
	 */
	public Result deleteQuestionAndOption(List<Question> qList) {
		for (Question q : qList) {
			if (!q.getSubquestionId().equals("")) {
				String[] subQuestions = q.getSubquestionId().split(",");
				for (String subQ : subQuestions) {
					QuestionExample qsubDelExample = new QuestionExample();
					QuestionExample.Criteria qsubCriteria = qsubDelExample.createCriteria();
					qsubCriteria.andQuestionIdEqualTo(subQ);
					int num1 = questionMapper.deleteByExample(qsubDelExample);
					if (num1 < 1) {
						return Result.failure(ResultCode.FAIL);
					}
				}

			} else {
				// 根据questionID删除问题表中的问题
				QuestionExample qDelExample = new QuestionExample();
				QuestionExample.Criteria qDelCriteria = qDelExample.createCriteria();
				qDelCriteria.andQuestionIdEqualTo(q.getQuestionId());
				int qDelnum1 = questionMapper.deleteByExample(qDelExample);
				if (qDelnum1 < 1) {
					return Result.failure(ResultCode.FAIL);
				}

			}
			QuestionOptionExample qOptionExample = new QuestionOptionExample();
			QuestionOptionExample.Criteria qOptionCriteria = qOptionExample.createCriteria();
			qOptionCriteria.andQuestionIdEqualTo(q.getQuestionId());
			int qOptionNum = questionoptionMapper.deleteByExample(qOptionExample);
			if (qOptionNum < 1) {
				return Result.failure(ResultCode.FAIL);
			}
		}
		return Result.success();
	}

	@Override
	public Result deleteByQuestionId(String questionId) {
		// TODO Auto-generated method stub
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria qCriteria = questionExample.createCriteria();
		qCriteria.andQuestionIdEqualTo(questionId);
		// 按照surverid查询出所有的问题，判断其是否有副问题，如果有，将副问题也删除
		List<Question> qList = questionMapper.selectByExample(questionExample);
		Result result = deleteQuestionAndOption(qList);
		int num = questionMapper.deleteByExample(questionExample);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}

	@Override
	public Result updateByQuestionId(QuestionResponse questionResponse) {
		// TODO Auto-generated method stub
		// 更新矩阵的副问题
		// deleteByQuestionId(questionResponse.getQuestionId());
		/**
		 * 还有问题稍后更改
		 */
		String subQues = "";
		System.out.println(questionResponse.getQuestions());
		if (questionResponse.getQuestions() != null) {
			for (Question subQuestion : questionResponse.getQuestions()) {
				subQues += subQuestion.getQuestionId();
				int subNum = questionMapper.updateByPrimaryKeySelective(subQuestion);
				if (subNum < 1) {
					return Result.failure(ResultCode.FAIL);
				}
			}
		}
		// 更新主问题
		Question question = new Question();
		question.setQuestionId(questionResponse.getQuestionId());
		question.setQuestionName(questionResponse.getTitle());
		question.setQuestionNeed(questionResponse.getRequired());
		question.setQuestionDirection(questionResponse.getSubdesc());
		question.setSubquestionId(subQues);
		int num = questionMapper.updateByPrimaryKeySelective(question);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		}
		// 更新选项
		for (QuestionOption qOption : questionResponse.getOptions()) {
			int num1 = questionoptionMapper.updateByPrimaryKeySelective(qOption);
			if (num1 < 1) {
				return Result.failure(ResultCode.FAIL);
			}
		}
		return Result.success();
	}

}
