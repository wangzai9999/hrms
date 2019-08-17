package com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.PrimitiveIterator;

public class Department  implements Serializable {
    private Long de_id;
    private String de_name;
    private Position list;
    private Userinfo de_man;

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

    public Position getList() {
        return list;
    }

    public void setList(Position list) {
        this.list = list;
    }

    public Userinfo getDe_man() {
        return de_man;
    }

    public void setDe_man(Userinfo de_man) {
        this.de_man = de_man;
    }
}
