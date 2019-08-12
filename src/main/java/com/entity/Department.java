package com.entity;

import java.util.List;

public class Department {
    private Long de_id;
    private String de_name;
    private List<Department> de_fa;

    public Long getDe_id() {
        return de_id;
    }

    public void setDe_id(Long de_id) {
        this.de_id = de_id;
    }

    public String getDe_name() {
        return de_name;
    }

    public void setDe_name(String de_name) {
        this.de_name = de_name;
    }

    public List<Department> getDe_fa() {
        return de_fa;
    }

    public void setDe_fa(List<Department> de_fa) {
        this.de_fa = de_fa;
    }
}
