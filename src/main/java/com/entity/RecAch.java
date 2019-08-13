package com.entity;

import java.io.Serializable;

public class RecAch implements Serializable {
    private Long ach_id;
    private Resume ach_resid;
    private Long ach_exam;
    private Long ach_interview;
    private Userinfo ach_auditor;
    private String ach_status;
    private String ach_comm;

    public Long getAch_id() {
        return ach_id;
    }

    public void setAch_id(Long ach_id) {
        this.ach_id = ach_id;
    }

    public Resume getAch_resid() {
        return ach_resid;
    }

    public void setAch_resid(Resume ach_resid) {
        this.ach_resid = ach_resid;
    }

    public Long getAch_exam() {
        return ach_exam;
    }

    public void setAch_exam(Long ach_exam) {
        this.ach_exam = ach_exam;
    }

    public Long getAch_interview() {
        return ach_interview;
    }

    public void setAch_interview(Long ach_interview) {
        this.ach_interview = ach_interview;
    }

    public Userinfo getAch_auditor() {
        return ach_auditor;
    }

    public void setAch_auditor(Userinfo ach_auditor) {
        this.ach_auditor = ach_auditor;
    }

    public String getAch_status() {
        return ach_status;
    }

    public void setAch_status(String ach_status) {
        this.ach_status = ach_status;
    }

    public String getAch_comm() {
        return ach_comm;
    }

    public void setAch_comm(String ach_comm) {
        this.ach_comm = ach_comm;
    }
}
