package com.entity;

import java.io.Serializable;

public class Role implements Serializable {

    private Long ro_id;
    private String ro_name;

    public Long getRo_id() {
        return ro_id;
    }

    public void setRo_id(Long ro_id) {
        this.ro_id = ro_id;
    }

    public String getRo_name() {
        return ro_name;
    }

    public void setRo_name(String ro_name) {
        this.ro_name = ro_name;
    }
}
