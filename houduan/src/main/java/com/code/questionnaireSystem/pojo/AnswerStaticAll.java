package com.code.questionnaireSystem.pojo;

import java.util.List;

import lombok.Data;

@Data
public class AnswerStaticAll {
	private String questionId;
	private String questionName;
	private List<AnswerStatic> answerStatics;

}
