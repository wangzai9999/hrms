package com.entity;

import java.io.Serializable;
import java.util.Date;

public class EngageMajorRelease implements Serializable {

    private Long en_id;
    private Department en_dep;
    private Position en_pos;
    private Long en_account;
    private Date en_deadline;
    private String en_major_describe;
    private String en_experience;
    private Userinfo en_creater;
    private Date en_createtime;
    private String en_status;

    public Long getEn_id() {
        return en_id;
    }

    public void setEn_id(Long en_id) {
        this.en_id = en_id;
    }

    public Department getEn_dep() {
        return en_dep;
    }

    public void setEn_dep(Department en_dep) {
        this.en_dep = en_dep;
    }

    public Position getEn_pos() {
        return en_pos;
    }

    public void setEn_pos(Position en_pos) {
        this.en_pos = en_pos;
    }

    public Long getEn_account() {
        return en_account;
    }

    public void setEn_account(Long en_account) {
        this.en_account = en_account;
    }

    public Date getEn_deadline() {
        return en_deadline;
    }

    public void setEn_deadline(Date en_deadline) {
        this.en_deadline = en_deadline;
    }

    public String getEn_major_describe() {
        return en_major_describe;
    }

    public void setEn_major_describe(String en_major_describe) {
        this.en_major_describe = en_major_describe;
    }

    public String getEn_experience() {
        return en_experience;
    }

    public void setEn_experience(String en_experience) {
        this.en_experience = en_experience;
    }

    public Userinfo getEn_creater() {
        return en_creater;
    }

    public void setEn_creater(Userinfo en_creater) {
        this.en_creater = en_creater;
    }

    public Date getEn_createtime() {
        return en_createtime;
    }

    public void setEn_createtime(Date en_createtime) {
        this.en_createtime = en_createtime;
    }

    public String getEn_status() {
        return en_status;
    }

    public void setEn_status(String en_status) {
        this.en_status = en_status;
    }
}
