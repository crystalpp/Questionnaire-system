package com.code.questionnaireSystem.pojo;

import java.io.Serializable;

public class SurverType implements Serializable {
    private String survertypeId;

    private String survertypeName;

    private Integer survertypeIsdelete;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getSurvertypeId() {
        return survertypeId;
    }

    public void setSurvertypeId(String survertypeId) {
        this.survertypeId = survertypeId == null ? null : survertypeId.trim();
    }

    public String getSurvertypeName() {
        return survertypeName;
    }

    public void setSurvertypeName(String survertypeName) {
        this.survertypeName = survertypeName == null ? null : survertypeName.trim();
    }

    public Integer getSurvertypeIsdelete() {
        return survertypeIsdelete;
    }

    public void setSurvertypeIsdelete(Integer survertypeIsdelete) {
        this.survertypeIsdelete = survertypeIsdelete;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}