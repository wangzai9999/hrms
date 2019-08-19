package com.entity;

import java.io.Serializable;

public class Userinfo implements Serializable {

    private Long us_id;
    private String us_name;
    private String us_password="123";
    private Role ro_id;
    private Department us_dep;
    private Position us_pos;

    private Long id;
    private String text;

    public Userinfo(){

    }
    public Userinfo(Long us_id){
        this.us_id=us_id;

    }

    public Long getUs_id() {
        return us_id;
    }

    public void setUs_id(Long us_id) {
        this.us_id = us_id;
        this.id=us_id;
    }

    public String getUs_name() {
        return us_name;
    }

    public void setUs_name(String us_name) {
        this.us_name = us_name;
        this.text=us_name;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

    public Role getRo_id() {
        return ro_id;
    }

    public void setRo_id(Role ro_id) {
        this.ro_id = ro_id;
    }

    public Department getUs_dep() {
        return us_dep;
    }

    public void setUs_dep(Department us_dep) {
        this.us_dep = us_dep;
    }

    public Position getUs_pos() {
        return us_pos;
    }

    public void setUs_pos(Position us_pos) {
        this.us_pos = us_pos;
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
}
