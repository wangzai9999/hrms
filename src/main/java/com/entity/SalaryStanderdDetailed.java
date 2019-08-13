package com.entity;

import java.io.Serializable;

public class SalaryStanderdDetailed implements Serializable{
    private Long si_id;
    private SalaryStanderd sa_id;
    private  String si_name;
    private Double si_money;

    public Long getSi_id() {
        return si_id;
    }

    public void setSi_id(Long si_id) {
        this.si_id = si_id;
    }

    public SalaryStanderd getSa_id() {
        return sa_id;
    }

    public void setSa_id(SalaryStanderd sa_id) {
        this.sa_id = sa_id;
    }

    public String getSi_name() {
        return si_name;
    }

    public void setSi_name(String si_name) {
        this.si_name = si_name;
    }

    public Double getSi_money() {
        return si_money;
    }

    public void setSi_money(Double si_money) {
        this.si_money = si_money;
    }
}
