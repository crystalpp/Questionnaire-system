package com.code.questionnaireSystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class Participate implements Serializable {
    private String participateId;

    private String participateIp;

    private String participateDevice;

    private String participateArea;

    private String participateSurverid;

    private Date participateStarttime;

    private Date participateEndtime;

    private static final long serialVersionUID = 1L;

    public String getParticipateId() {
        return participateId;
    }

    public void setParticipateId(String participateId) {
        this.participateId = participateId == null ? null : participateId.trim();
    }

    public String getParticipateIp() {
        return participateIp;
    }

    public void setParticipateIp(String participateIp) {
        this.participateIp = participateIp == null ? null : participateIp.trim();
    }

    public String getParticipateDevice() {
        return participateDevice;
    }

    public void setParticipateDevice(String participateDevice) {
        this.participateDevice = participateDevice == null ? null : participateDevice.trim();
    }

    public String getParticipateArea() {
        return participateArea;
    }

    public void setParticipateArea(String participateArea) {
        this.participateArea = participateArea == null ? null : participateArea.trim();
    }

    public String getParticipateSurverid() {
        return participateSurverid;
    }

    public void setParticipateSurverid(String participateSurverid) {
        this.participateSurverid = participateSurverid == null ? null : participateSurverid.trim();
    }

    public Date getParticipateStarttime() {
        return participateStarttime;
    }

    public void setParticipateStarttime(Date participateStarttime) {
        this.participateStarttime = participateStarttime;
    }

    public Date getParticipateEndtime() {
        return participateEndtime;
    }

    public void setParticipateEndtime(Date participateEndtime) {
        this.participateEndtime = participateEndtime;
    }
}