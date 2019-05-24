package com.code.questionnaireSystem.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class AnswerStatic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String questionId;
	private String questionName;
	private Integer questionType;
	List<AnswerStaticItem> listAnswer;

}
