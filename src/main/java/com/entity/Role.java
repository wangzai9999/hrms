package com.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private Long ro_id;
    private String ro_name;

    private List<Powers> list;
    public Role() {
    }

    /** minimal constructor */
    public Role(String ro_name) {
        this.ro_name = ro_name;
    }

    /** full constructor */
    public Role(String ro_name, List<Powers> list) {
        this.ro_name = ro_name;
        this.list = list;
    }
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

    public List<Powers> getList() {
        return list;
    }

    public void setList(List<Powers> list) {
        this.list = list;
    }
}
