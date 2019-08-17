package com.entity;

import java.io.Serializable;

public class Position implements Serializable {

    private Long pos_id;//职位编号
    private String pos_name;//职位名
    private Department pos_dep;

    public Position(){

    }
    public Position(Long pos_id){
        this.pos_id = pos_id;
    }

    public Long getPos_id() {
        return pos_id;
    }

    public void setPos_id(Long pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public Department getPos_dep() {
        return pos_dep;
    }

    public void setPos_dep(Department pos_dep) {
        this.pos_dep = pos_dep;
    }
}
