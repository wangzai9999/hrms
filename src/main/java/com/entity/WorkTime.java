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
    private String wt_bstatus;
    private String wt_estatus;

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

    public String getWt_bstatus() {
        return wt_bstatus;
    }

    public void setWt_bstatus(String wt_bstatus) {
        this.wt_bstatus = wt_bstatus;
    }

    public String getWt_estatus() {
        return wt_estatus;
    }

    public void setWt_estatus(String wt_estatus) {
        this.wt_estatus = wt_estatus;
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "wt_id=" + wt_id +
                ", us_id=" + us_id +
                ", wt_begin=" + wt_begin +
                ", wt_end=" + wt_end +
                ", wt_bstatus='" + wt_bstatus + '\'' +
                ", wt_estatus='" + wt_estatus + '\'' +
                '}';
    }
}
