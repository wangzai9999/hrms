package com.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class TrainingApplyFo implements Serializable{


    private Long tf_id;
    private Userinfo tf_us_id;
    private TrainingInfo tf_tr_id;
    private String tf_status;
    private Date tf_date;
    private String tf_auditor;
    private String tf_opinion;

    public Long getTf_id() {
        return tf_id;
    }

    public void setTf_id(Long tf_id) {
        this.tf_id = tf_id;
    }

    public Userinfo getTf_us_id() {
        return tf_us_id;
    }

    public void setTf_us_id(Userinfo tf_us_id) {
        this.tf_us_id = tf_us_id;
    }

    public TrainingInfo getTf_tr_id() {
        return tf_tr_id;
    }

    public void setTf_tr_id(TrainingInfo tf_tr_id) {
        this.tf_tr_id = tf_tr_id;
    }

    public String getTf_status() {
        return tf_status;
    }

    public void setTf_status(String tf_status) {
        this.tf_status = tf_status;
    }

    public Date getTf_date() {
        return tf_date;
    }

    public void setTf_date(Date tf_date) {
        this.tf_date = tf_date;
    }

    public String getTf_auditor() {
        return tf_auditor;
    }

    public void setTf_auditor(String tf_auditor) {
        this.tf_auditor = tf_auditor;
    }

    public String getTf_opinion() {
        return tf_opinion;
    }

    public void setTf_opinion(String tf_opinion) {
        this.tf_opinion = tf_opinion;
    }
}
