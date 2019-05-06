package com.code.questionnaireSystem.pojo;

import java.io.Serializable;

public class Select implements Serializable {
    private Integer selectId;

    private String selectContent;

    private String selectScore;

    private String questionId;

    private static final long serialVersionUID = 1L;

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getSelectContent() {
        return selectContent;
    }

    public void setSelectContent(String selectContent) {
        this.selectContent = selectContent == null ? null : selectContent.trim();
    }

    public String getSelectScore() {
        return selectScore;
    }

    public void setSelectScore(String selectScore) {
        this.selectScore = selectScore == null ? null : selectScore.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }
}