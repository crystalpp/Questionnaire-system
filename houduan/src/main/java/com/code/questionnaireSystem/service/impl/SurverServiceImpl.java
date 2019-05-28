package com.code.questionnaireSystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.questionnaireSystem.mapper.QuestionMapper;
import com.code.questionnaireSystem.mapper.QuestionOptionMapper;
import com.code.questionnaireSystem.mapper.SurverMapper;
import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.pojo.QuestionExample;
import com.code.questionnaireSystem.pojo.QuestionOption;
import com.code.questionnaireSystem.pojo.QuestionOptionExample;
import com.code.questionnaireSystem.pojo.QuestionsResult;
import com.code.questionnaireSystem.pojo.Surver;
import com.code.questionnaireSystem.pojo.SurverExample;
import com.code.questionnaireSystem.service.SurverService;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

@Service
public class SurverServiceImpl implements SurverService {
	@Autowired
	private SurverMapper surverMapper;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionOptionMapper questionoptionMapper;

	@Override
	public Result insert(String userId, String surverTypeId) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString().substring(0, 10);
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date createTime = new Date();
		Surver surver = new Surver();
		surver.setSurverCreattime(createTime);
		surver.setSurverId(id);
		surver.setUserId(userId);
		surver.setSurvertypeId(surverTypeId);
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

	@Override
	public Result selectSurvers(String surverTypeId, String surverTitle) {
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		if (!surverTypeId.equals("")) {
			criteria.andSurvertypeIdEqualTo(surverTypeId);
		}
		criteria.andSurverTitleLike("%" + surverTitle + "%");
		List<Surver> survers = surverMapper.selectByExample(surverExample);
		return Result.success(survers);
	}

	@Override
	public Result getTemplate(String surverTypeId) {
		// TODO Auto-generated method stub
		SurverExample surverExample = new SurverExample();
		SurverExample.Criteria criteria = surverExample.createCriteria();
		if (!surverTypeId.equals("")) {
			criteria.andSurvertypeIdEqualTo(surverTypeId);
		}
		criteria.andSurverIstemplateEqualTo(1);
		List<Surver> survers = surverMapper.selectByExample(surverExample);
		return Result.success(survers);

	}

	@Override
	public Result updateSurverType(String surverId, String surverTypeId) {
		// TODO Auto-generated method stub
		Surver surver = new Surver();
		surver.setSurverId(surverId);
		surver.setSurvertypeId(surverTypeId);
		int num = surverMapper.updateByPrimaryKeySelective(surver);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}

	}

	@Override
	public Result updateRecoverNum(String surverId) {
		// TODO Auto-generated method stub
		Surver surver = surverMapper.selectByPrimaryKey(surverId);
		surver.setSurverRecovernum(surver.getSurverRecovernum() + 1);
		int num = surverMapper.updateByPrimaryKeySelective(surver);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		} else {
			return Result.success();
		}
	}

	public List<QuestionsResult> getQuestionsBySurverId(String surverId) {
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
		return questionsResults;
	}

	public Integer add(String title, String subdesc, String type, String required, String options, String surverId,
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
					return subQuestionNum;
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
					return selectInsert;
				}

			}
		}
		return num;
	}

	@Override
	public Result creatByTemplate(String templateSurverId, String userId) {
		// TODO Auto-generated method stub
		// 先得到问卷模板的相关信息，然后新增操作，为自己的问卷
		Surver surver = surverMapper.selectByPrimaryKey(templateSurverId);
		Surver newSurver = new Surver();
		String surverId1 = UUID.randomUUID().toString().substring(0, 10);
		newSurver.setSurverId(surverId1);
		newSurver.setSurverTitle(surver.getSurverTitle());
		newSurver.setSurverDescription(surver.getSurverDescription());
		newSurver.setSurverCreattime(new Date());
		newSurver.setSurvertypeId(surver.getSurvertypeId());
		newSurver.setSurverLimitip(surver.getSurverLimitip());
		newSurver.setUserId(userId);
		int num = surverMapper.insertSelective(newSurver);
		if (num < 1) {
			return Result.failure(ResultCode.FAIL);
		}
		// 根据模板问卷的id先查询到所有的问题，然后再将所有的问题插入数据库
		List<QuestionsResult> questionsResults = getQuestionsBySurverId(templateSurverId);
		for (QuestionsResult questionsResult : questionsResults) {
			// String surverId = questionsResult.getSurverId();
			String questionNeed = questionsResult.getQuestionNeed();
			String questionName = questionsResult.getQuestionName();
			String questionDirection = questionsResult.getQuestionDirection();
			String questionType = questionsResult.getQuetypeId();
			String subQuestions = null;
			String options = null;
			if (questionsResult.getSubQuestions() != null) {
				subQuestions = "";
				for (Question question : questionsResult.getSubQuestions()) {
					subQuestions += question.getQuestionName();
					subQuestions += ",";
				}
			}
			if (questionsResult.getOptions().size() > 0) {
				options = "";
				for (QuestionOption questionOption : questionsResult.getOptions()) {
					options += questionOption.getOptionContent();
					options += ",";
				}
			}
			Integer num1 = add(questionName, questionDirection, questionType, questionNeed, options, surverId1,
					subQuestions);
			if (num1 < 1) {
				return Result.failure(ResultCode.FAIL);
			}
		}
		return Result.success(surverId1);
	}

}
