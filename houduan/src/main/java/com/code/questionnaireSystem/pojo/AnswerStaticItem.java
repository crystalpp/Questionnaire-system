package com.code.questionnaireSystem.pojo;

import lombok.Data;

@Data
public class AnswerStaticItem {
	private String subQuestionId;
	private String subQuestionName;
	private String optionId;
	private String optionContent;
	private String answerText;
	private Integer num;
}
