package com.entity;

import java.io.Serializable;

public class Powers implements Serializable {

    private Long po_id;
    private String po_name;
    private String po_url;
    private Powers po_fa;

    public Long getPo_id() {
        return po_id;
    }

    public void setPo_id(Long po_id) {
        this.po_id = po_id;
    }

    public String getPo_name() {
        return po_name;
    }

    public void setPo_name(String po_name) {
        this.po_name = po_name;
    }

    public String getPo_url() {
        return po_url;
    }

    public void setPo_url(String po_url) {
        this.po_url = po_url;
    }

    public Powers getPo_fa() {
        return po_fa;
    }

    public void setPo_fa(Powers po_fa) {
        this.po_fa = po_fa;
    }
}
