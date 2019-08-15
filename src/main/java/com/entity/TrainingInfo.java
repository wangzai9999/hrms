package com.entity;

import java.io.Serializable;
import java.util.Date;

public class TrainingInfo implements Serializable {

    private Long tr_id;
    private String tr_man;
    private String tr_subject;
    private String tr_status;
    private Date tr_starttime;
    private Date tr_endtime;
    private String tr_remark;

    public Long getTr_id() {
        return tr_id;
    }

    public void setTr_id(Long tr_id) {
        this.tr_id = tr_id;
    }

    public String getTr_man() {
        return tr_man;
    }

    public void setTr_man(String tr_man) {
        this.tr_man = tr_man;
    }

    public String getTr_subject() {
        return tr_subject;
    }

    public void setTr_subject(String tr_subject) {
        this.tr_subject = tr_subject;
    }

    public String getTr_status() {
        return tr_status;
    }

    public void setTr_status(String tr_status) {
        this.tr_status = tr_status;
    }

    public Date getTr_starttime() {
        return tr_starttime;
    }

    public void setTr_starttime(Date tr_starttime) {
        this.tr_starttime = tr_starttime;
    }

    public Date getTr_endtime() {
        return tr_endtime;
    }

    public void setTr_endtime(Date tr_endtime) {
        this.tr_endtime = tr_endtime;
    }

    public String getTr_remark() {
        return tr_remark;
    }

    public void setTr_remark(String tr_remark) {
        this.tr_remark = tr_remark;
    }
}
