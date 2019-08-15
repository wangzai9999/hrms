package com.util;

import java.io.Serializable;
import java.util.Date;

public class EngageParam implements Serializable {

    private Long depid;
    private Long posid;
    private Long account;
    private Date mintime;
    private Date maxtime;

    public Long getDepid() {
        return depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public Long getPosid() {
        return posid;
    }

    public void setPosid(Long posid) {
        this.posid = posid;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Date getMintime() {
        return mintime;
    }

    public void setMintime(Date mintime) {
        this.mintime = mintime;
    }

    public Date getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(Date maxtime) {
        this.maxtime = maxtime;
    }
}
