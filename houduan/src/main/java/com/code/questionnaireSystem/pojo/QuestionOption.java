package com.code.questionnaireSystem.pojo;

import java.io.Serializable;

public class QuestionOption implements Serializable {
    private String optionId;

    private String optionContent;

    private String optionScore;

    private String subquestionId;

    private String questionId;

    private static final long serialVersionUID = 1L;

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId == null ? null : optionId.trim();
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent == null ? null : optionContent.trim();
    }

    public String getOptionScore() {
        return optionScore;
    }

    public void setOptionScore(String optionScore) {
        this.optionScore = optionScore == null ? null : optionScore.trim();
    }

    public String getSubquestionId() {
        return subquestionId;
    }

    public void setSubquestionId(String subquestionId) {
        this.subquestionId = subquestionId == null ? null : subquestionId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }
}