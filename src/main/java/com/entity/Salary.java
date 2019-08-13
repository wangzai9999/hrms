package com.entity;

import java.io.Serializable;

public class Salary implements Serializable {
    private Long sl_id;
    private  Userinfo sl_ud_id;
    private Long sl_sal;

    public Long getSl_id() {
        return sl_id;
    }

    public void setSl_id(Long sl_id) {
        this.sl_id = sl_id;
    }

    public Userinfo getSl_ud_id() {
        return sl_ud_id;
    }

    public void setSl_ud_id(Userinfo sl_ud_id) {
        this.sl_ud_id = sl_ud_id;
    }

    public Long getSl_sal() {
        return sl_sal;
    }

    public void setSl_sal(Long sl_sal) {
        this.sl_sal = sl_sal;
    }
}
