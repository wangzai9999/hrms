package com.entity;

import org.apache.ibatis.annotations.Param;
import sun.dc.pr.PRError;

import java.io.Serializable;
import java.util.Date;

public class WorkTime implements Serializable {
    private Long wt_id;
    private Userinfo us_id;
    private Date wt_begin;
    private Date wt_end;
    private String wt_status;

    public Long getWt_id() {
        return wt_id;
    }

    public void setWt_id(Long wt_id) {
        this.wt_id = wt_id;
    }

    public Userinfo getUs_id() {
        return us_id;
    }

    public void setUs_id(Userinfo us_id) {
        this.us_id = us_id;
    }

    public Date getWt_begin() {
        return wt_begin;
    }

    public void setWt_begin(Date wt_begin) {
        this.wt_begin = wt_begin;
    }

    public Date getWt_end() {
        return wt_end;
    }

    public void setWt_end(Date wt_end) {
        this.wt_end = wt_end;
    }

    public String getWt_status() {
        return wt_status;
    }

    public void setWt_status(String wt_status) {
        this.wt_status = wt_status;
    }
}
