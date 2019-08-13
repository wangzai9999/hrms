package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable {

    private Long re_id;
    private String re_name;
    private String re_position;
    private EngageMajorRelease re_enid;
    private Date re_time;
    private String re_url;

    public Long getRe_id() {
        return re_id;
    }

    public void setRe_id(Long re_id) {
        this.re_id = re_id;
    }

    public String getRe_name() {
        return re_name;
    }

    public void setRe_name(String re_name) {
        this.re_name = re_name;
    }

    public String getRe_position() {
        return re_position;
    }

    public void setRe_position(String re_position) {
        this.re_position = re_position;
    }

    public EngageMajorRelease getRe_enid() {
        return re_enid;
    }

    public void setRe_enid(EngageMajorRelease re_enid) {
        this.re_enid = re_enid;
    }

    public String getRe_url() {
        return re_url;
    }

    public void setRe_url(String re_url) {
        this.re_url = re_url;
    }

    public Date getRe_time() {
        return re_time;
    }

    public void setRe_time(Date re_time) {
        this.re_time = re_time;
    }
}
