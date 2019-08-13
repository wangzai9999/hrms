package com.entity;

import java.io.Serializable;

public class Trainers implements Serializable {

    private Long ts_id;
    private Resume ts_trid;
    private String ts_comm;

    public Long getTs_id() {
        return ts_id;
    }

    public void setTs_id(Long ts_id) {
        this.ts_id = ts_id;
    }

    public Resume getTs_trid() {
        return ts_trid;
    }

    public void setTs_trid(Resume ts_trid) {
        this.ts_trid = ts_trid;
    }

    public String getTs_comm() {
        return ts_comm;
    }

    public void setTs_comm(String ts_comm) {
        this.ts_comm = ts_comm;
    }
}
