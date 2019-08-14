package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SalaryStanderd implements Serializable {
    private Long sa_id;
    private String sa_name;
    private Double sa_totalmoney;
    private String sa_remark;
    private Userinfo sa_cre_id;
    private Date sa_date;
    private Position sa_pos;
    private List<SalaryStanderdDetailed> list;

    public Long getSa_id() {
        return sa_id;
    }

    public void setSa_id(Long sa_id) {
        this.sa_id = sa_id;
    }

    public String getSa_name() {
        return sa_name;
    }

    public void setSa_name(String sa_name) {
        this.sa_name = sa_name;
    }

    public Double getSa_totalmoney() {
        return sa_totalmoney;
    }

    public void setSa_totalmoney(Double sa_totalmoney) {
        this.sa_totalmoney = sa_totalmoney;
    }

    public String getSa_remark() {
        return sa_remark;
    }

    public void setSa_remark(String sa_remark) {
        this.sa_remark = sa_remark;
    }

    public Userinfo getSa_cre_id() {
        return sa_cre_id;
    }

    public void setSa_cre_id(Userinfo sa_cre_id) {
        this.sa_cre_id = sa_cre_id;
    }

    public Date getSa_date() {
        return sa_date;
    }

    public void setSa_date(Date sa_date) {
        this.sa_date = sa_date;
    }

    public Position getSa_pos() {
        return sa_pos;
    }

    public void setSa_pos(Position sa_pos) {
        this.sa_pos = sa_pos;
    }

    public List<SalaryStanderdDetailed> getList() {
        return list;
    }

    public void setList(List<SalaryStanderdDetailed> list) {
        this.list = list;
    }
}
