package com.code.questionnaireSystem.response;

import java.util.List;

import com.code.questionnaireSystem.pojo.Question;
import com.code.questionnaireSystem.pojo.QuestionOption;

import lombok.Data;

@Data
public class QuestionResponse {
	private String title;
	private String subdesc;
	private String type;
	private String required;
	private List<QuestionOption> options;
	private String surverId;
	private List<Question> questions;
	private String questionId;

}
