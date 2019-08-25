package com.entity;

import java.io.Serializable;

public class Trainers implements Serializable {

    private Long ts_id;
    private Userinfo ts_usid;
    private TrainingInfo ts_trid;
    private String ts_comm="无";

    private String starNum="0";

    public Long getTs_id() {
        return ts_id;
    }

    public void setTs_id(Long ts_id) {
        this.ts_id = ts_id;
    }

    public Userinfo getTs_usid() {
        return ts_usid;
    }

    public void setTs_usid(Userinfo ts_usid) {
        this.ts_usid = ts_usid;
    }

    public TrainingInfo getTs_trid() {
        return ts_trid;
    }

    public void setTs_trid(TrainingInfo ts_trid) {
        this.ts_trid = ts_trid;
    }

    public String getTs_comm() {
        return ts_comm;
    }

    public void setTs_comm(String ts_comm) {
        this.ts_comm = ts_comm;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
    }
}
