package com.code.questionnaireSystem.pojo;

import java.io.Serializable;

public class Answer implements Serializable {
    private String answerId;

    private String questionId;

    private String subquestionId;

    private String optionId;

    private String participateId;

    private static final long serialVersionUID = 1L;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getSubquestionId() {
        return subquestionId;
    }

    public void setSubquestionId(String subquestionId) {
        this.subquestionId = subquestionId == null ? null : subquestionId.trim();
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId == null ? null : optionId.trim();
    }

    public String getParticipateId() {
        return participateId;
    }

    public void setParticipateId(String participateId) {
        this.participateId = participateId == null ? null : participateId.trim();
    }
}