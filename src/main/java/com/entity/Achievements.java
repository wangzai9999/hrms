package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Achievements implements Serializable {
    private Long av_id;
    private Userinfo us_id;
    private Userinfo av_man;
    private Long av_day_score;
    private Long av_man_score;
    private Date av_ym;
    private Long av_sr;

    public Long getAv_id() {
        return av_id;
    }

    public void setAv_id(Long av_id) {
        this.av_id = av_id;
    }

    public Userinfo getUs_id() {
        return us_id;
    }

    public void setUs_id(Userinfo us_id) {
        this.us_id = us_id;
    }

    public Userinfo getAv_man() {
        return av_man;
    }

    public void setAv_man(Userinfo av_man) {
        this.av_man = av_man;
    }

    public Long getAv_day_score() {
        return av_day_score;
    }

    public void setAv_day_score(Long av_day_score) {
        this.av_day_score = av_day_score;
    }

    public Long getAv_man_score() {
        return av_man_score;
    }

    public void setAv_man_score(Long av_man_score) {
        this.av_man_score = av_man_score;
    }

    public Date getAv_ym() {
        return av_ym;
    }

    public void setAv_ym(Date av_ym) {
        this.av_ym = av_ym;
    }

    public Long getAv_sr() {
        return av_sr;
    }

    public void setAv_sr(Long av_sr) {
        this.av_sr = av_sr;
    }
}
