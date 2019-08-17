package com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.PrimitiveIterator;

public class Department  implements Serializable {
    private Long de_id;
    private String de_name;
    private List<Position> children;
    private Userinfo de_man;

    private Long id;
    private String text;


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

    public List<Position> getChildren() {
        return children;
    }

    public void setChildren(List<Position> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        this.de_id=id;
    }

    public String getText() {
        return text;

    }

    public void setText(String text) {
        this.text = text;
        this.de_name=text;
    }

    public Userinfo getDe_man() {
        return de_man;
    }

    public void setDe_man(Userinfo de_man) {
        this.de_man = de_man;
    }
}
