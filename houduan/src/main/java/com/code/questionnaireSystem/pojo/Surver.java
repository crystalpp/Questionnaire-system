package com.code.questionnaireSystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class Surver implements Serializable {
    private String surverId;

    private String surverTitle;

    private String surverDescription;

    private Date surverCreattime;

    private Date surverPulishstarttime;

    private Date surverEndtime;

    private Integer surverRecovernum;

    private Integer surverIstemplate;

    private Integer surverLimitip;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getSurverId() {
        return surverId;
    }

    public void setSurverId(String surverId) {
        this.surverId = surverId == null ? null : surverId.trim();
    }

    public String getSurverTitle() {
        return surverTitle;
    }

    public void setSurverTitle(String surverTitle) {
        this.surverTitle = surverTitle == null ? null : surverTitle.trim();
    }

    public String getSurverDescription() {
        return surverDescription;
    }

    public void setSurverDescription(String surverDescription) {
        this.surverDescription = surverDescription == null ? null : surverDescription.trim();
    }

    public Date getSurverCreattime() {
        return surverCreattime;
    }

    public void setSurverCreattime(Date surverCreattime) {
        this.surverCreattime = surverCreattime;
    }

    public Date getSurverPulishstarttime() {
        return surverPulishstarttime;
    }

    public void setSurverPulishstarttime(Date surverPulishstarttime) {
        this.surverPulishstarttime = surverPulishstarttime;
    }

    public Date getSurverEndtime() {
        return surverEndtime;
    }

    public void setSurverEndtime(Date surverEndtime) {
        this.surverEndtime = surverEndtime;
    }

    public Integer getSurverRecovernum() {
        return surverRecovernum;
    }

    public void setSurverRecovernum(Integer surverRecovernum) {
        this.surverRecovernum = surverRecovernum;
    }

    public Integer getSurverIstemplate() {
        return surverIstemplate;
    }

    public void setSurverIstemplate(Integer surverIstemplate) {
        this.surverIstemplate = surverIstemplate;
    }

    public Integer getSurverLimitip() {
        return surverLimitip;
    }

    public void setSurverLimitip(Integer surverLimitip) {
        this.surverLimitip = surverLimitip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}