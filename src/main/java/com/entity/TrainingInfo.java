package com.entity;

import org.aspectj.lang.annotation.After;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class TrainingInfo implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "select tr_seq.nextval from dual")
    private Long tr_id;

    @NotEmpty(message = "不能为空")
    private String tr_man;
    @NotEmpty(message = "不能为空")
    private String tr_subject;
    private String tr_status="新增，请等待";
    @NotEmpty(message = "不能为空")
    @Pattern(regexp = "/\\d+/",message = "请填写数字")
    private Long tr_num;
    private Long tr_havnum;
    @NotEmpty(message = "不能为空")
    @Future(message="开始时间不能早于当前时间！")
    private Date tr_starttime;
    @NotEmpty(message = "不能为空")
    @Future(message="结束时间不能早于当前时间！")
    private Date tr_endtime;

    private String tr_remark;

    private String pj;
    private Long pf;

    public TrainingInfo(){}
    public Long getTr_id() {
        return tr_id;
    }

    public void setTr_id(Long tr_id) {
        this.tr_id = tr_id;
    }

    public String getTr_man() {
        return tr_man;
    }

    public void setTr_man(String tr_man) {
        this.tr_man = tr_man;
    }

    public String getTr_subject() {
        return tr_subject;
    }

    public void setTr_subject(String tr_subject) {
        this.tr_subject = tr_subject;
    }

    public String getTr_status() {
        return tr_status;
    }

    public void setTr_status(String tr_status) {
        this.tr_status = tr_status;
    }

    public Date getTr_starttime() {
        return tr_starttime;
    }

    public void setTr_starttime(Date tr_starttime) {
        this.tr_starttime = tr_starttime;
    }

    public Date getTr_endtime() {
        return tr_endtime;
    }

    public void setTr_endtime(Date tr_endtime) {
        this.tr_endtime = tr_endtime;
    }

    public String getTr_remark() {
        return tr_remark;
    }

    public void setTr_remark(String tr_remark) {
        this.tr_remark = tr_remark;
    }

    public Long getTr_num() {
        return tr_num;
    }

    public void setTr_num(Long tr_num) {
        this.tr_num = tr_num;
    }

    public Long getTr_havnum() {
        return tr_havnum;
    }

    public void setTr_havnum(Long tr_havnum) {
        this.tr_havnum = tr_havnum;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public Long getPf() {
        return pf;
    }

    public void setPf(Long pf) {
        this.pf = pf;
    }
}
