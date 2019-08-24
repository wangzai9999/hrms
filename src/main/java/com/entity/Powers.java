package com.entity;

import java.io.Serializable;
import java.util.List;

public class Powers implements Serializable {

    private String po_url;
    private Powers po_fa;

    private Long id;
    private String text;
    private List<Powers> children;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Powers> getChildren() {
        return children;
    }

    public void setChildren(List<Powers> children) {
        this.children = children;
    }
}
