package com.util;

import java.util.Date;

public class TrainingInfoParam {

    private String tr_subject;
    private String tr_status;
    private Date minstarttime;
    private Date maxstarttime;

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

    public Date getMinstarttime() {
        return minstarttime;
    }

    public Date getMaxstarttime() {
        return maxstarttime;
    }

    public void setMaxstarttime(Date maxstarttime) {
        this.maxstarttime = maxstarttime;
    }

    public void setMinstarttime(Date minstarttime) {
        this.minstarttime = minstarttime;

    }
}
