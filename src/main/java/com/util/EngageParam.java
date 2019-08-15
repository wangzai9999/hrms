package com.util;

import java.io.Serializable;
import java.util.Date;

public class EngageParam implements Serializable {

    private Long depid;
    private Long posid;
    private Long minaccount;
    private Long maxaccount;
    private Date mintime;
    private Date maxtime;
    private String experience;

    public Long getDepid() {
        return depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public Long getPosid() {
        return posid;
    }

    public void setPosid(Long posid) {
        this.posid = posid;
    }

    public Long getMinaccount() {
        return minaccount;
    }

    public void setMinaccount(Long minaccount) {
        this.minaccount = minaccount;
    }

    public Long getMaxaccount() {
        return maxaccount;
    }

    public void setMaxaccount(Long maxaccount) {
        this.maxaccount = maxaccount;
    }

    public Date getMintime() {
        return mintime;
    }

    public void setMintime(Date mintime) {
        this.mintime = mintime;
    }

    public Date getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(Date maxtime) {
        this.maxtime = maxtime;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
