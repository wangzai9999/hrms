package com.entity;

import java.io.Serializable;
import java.util.List;

public class Department  implements Serializable {
    private Long de_id;
    private String de_name;
    private Department de_fa;

    public Department(){

    }
    public Department(Long de_id){
        this.de_id= de_id;
    }

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

    public Department getDe_fa() {
        return de_fa;
    }

    public void setDe_fa(Department de_fa) {
        this.de_fa = de_fa;
    }
}
