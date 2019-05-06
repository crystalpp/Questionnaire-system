package com.code.questionnaireSystem.pojo;

import java.io.Serializable;

public class Question implements Serializable {
	private String questionId;

	private String questionName;

	private String questionDirection;

	private String questionNeed;

	private String quetypeId;

	private String surverId;

	private static final long serialVersionUID = 1L;

	public Question() {
		super();
	}

	public Question(String questionId, String questionName, String questionDirection, String questionNeed,
			String quetypeId, String surverId) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.questionDirection = questionDirection;
		this.questionNeed = questionNeed;
		this.quetypeId = quetypeId;
		this.surverId = surverId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId == null ? null : questionId.trim();
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName == null ? null : questionName.trim();
	}

	public String getQuestionDirection() {
		return questionDirection;
	}

	public void setQuestionDirection(String questionDirection) {
		this.questionDirection = questionDirection == null ? null : questionDirection.trim();
	}

	public String getQuestionNeed() {
		return questionNeed;
	}

	public void setQuestionNeed(String questionNeed) {
		this.questionNeed = questionNeed == null ? null : questionNeed.trim();
	}

	public String getQuetypeId() {
		return quetypeId;
	}

	public void setQuetypeId(String quetypeId) {
		this.quetypeId = quetypeId == null ? null : quetypeId.trim();
	}

	public String getSurverId() {
		return surverId;
	}

	public void setSurverId(String surverId) {
		this.surverId = surverId == null ? null : surverId.trim();
	}
}