package com.code.questionnaireSystem.pojo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 封装返回的每个问题的具体实体类
 * 
 * @author 皮艳萍
 *
 */
@Data
public class QuestionsResult {
	private String questionId;

	private String questionName;

	private String questionDirection;

	private String questionNeed;

	private String quetypeId;

	private Date questionCreatTime;

	private String surverId;

	private List<QuestionOption> options;

	private List<Question> subQuestions;

}
