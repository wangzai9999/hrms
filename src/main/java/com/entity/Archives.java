package com.entity;

import org.apache.ibatis.annotations.ResultMap;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Archives implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "select ar_seq.nextval from dual")
    private Long ar_id;
    @Transient
    private Userinfo ar_uid;
    private String ar_id_card;
    private String ar_photo;
    private String ar_regist;
    private String ar_change="尚未变更记录，无变更人";
    private Date ar_regist_time;
    private Date ar_change_time;
    private String ar_status="正常";
    private String ar_address;
    private String ar_telephone;
    private String ar_email="无";
    private String ar_speciality="无";
    private String ar_sex;
    private String ar_party;
    private String ar_nationality;
    private String ar_race;
    private Date ar_birthday;
    private String ar_birthplace;
    private Long ar_age;
    private String ar_educated_degree;
    private String ar_educated_major;
    private String ar_gzjl="无";
    private Long ar_gl;
    private String ar_love="无";
    private String ar_qq="无";

    public Long getAr_id() {
        return ar_id;
    }

    public void setAr_id(Long ar_id) {
        this.ar_id = ar_id;
    }

    public Userinfo getAr_uid() {
        return ar_uid;
    }

    public void setAr_uid(Userinfo ar_uid) {
        this.ar_uid = ar_uid;
    }

    public String getAr_id_card() {
        return ar_id_card;
    }

    public void setAr_id_card(String ar_id_card) {
        this.ar_id_card = ar_id_card;
    }

    public String getAr_photo() {
        return ar_photo;
    }

    public void setAr_photo(String ar_photo) {
        this.ar_photo = ar_photo;
    }

    public String getAr_regist() {
        return ar_regist;
    }

    public void setAr_regist(String ar_regist) {
        this.ar_regist = ar_regist;
    }

    public String getAr_change() {
        return ar_change;
    }

    public void setAr_change(String ar_change) {
        this.ar_change = ar_change;
    }

    public Date getAr_regist_time() {
        return ar_regist_time;
    }

    public void setAr_regist_time(Date ar_regist_time) {
        this.ar_regist_time = ar_regist_time;
    }

    public Date getAr_change_time() {
        return ar_change_time;
    }

    public void setAr_change_time(Date ar_change_time) {
        this.ar_change_time = ar_change_time;
    }

    public String getAr_status() {
        return ar_status;
    }

    public void setAr_status(String ar_status) {
        this.ar_status = ar_status;
    }

    public String getAr_address() {
        return ar_address;
    }

    public void setAr_address(String ar_address) {
        this.ar_address = ar_address;
    }

    public String getAr_telephone() {
        return ar_telephone;
    }

    public void setAr_telephone(String ar_telephone) {
        this.ar_telephone = ar_telephone;
    }

    public String getAr_email() {
        return ar_email;
    }

    public void setAr_email(String ar_email) {
        this.ar_email = ar_email;
    }

    public String getAr_speciality() {
        return ar_speciality;
    }

    public void setAr_speciality(String ar_speciality) {
        this.ar_speciality = ar_speciality;
    }

    public String getAr_sex() {
        return ar_sex;
    }

    public void setAr_sex(String ar_sex) {
        this.ar_sex = ar_sex;
    }

    public String getAr_party() {
        return ar_party;
    }

    public void setAr_party(String ar_party) {
        this.ar_party = ar_party;
    }

    public String getAr_nationality() {
        return ar_nationality;
    }

    public void setAr_nationality(String ar_nationality) {
        this.ar_nationality = ar_nationality;
    }

    public String getAr_race() {
        return ar_race;
    }

    public void setAr_race(String ar_race) {
        this.ar_race = ar_race;
    }

    public Date getAr_birthday() {
        return ar_birthday;
    }

    public void setAr_birthday(Date ar_birthday) {
        this.ar_birthday = ar_birthday;
    }

    public String getAr_birthplace() {
        return ar_birthplace;
    }

    public void setAr_birthplace(String ar_birthplace) {
        this.ar_birthplace = ar_birthplace;
    }

    public Long getAr_age() {
        return ar_age;
    }

    public void setAr_age(Long ar_age) {
        this.ar_age = ar_age;
    }

    public String getAr_educated_degree() {
        return ar_educated_degree;
    }

    public void setAr_educated_degree(String ar_educated_degree) {
        this.ar_educated_degree = ar_educated_degree;
    }

    public String getAr_educated_major() {
        return ar_educated_major;
    }

    public void setAr_educated_major(String ar_educated_major) {
        this.ar_educated_major = ar_educated_major;
    }

    public String getAr_gzjl() {
        return ar_gzjl;
    }

    public void setAr_gzjl(String ar_gzjl) {
        this.ar_gzjl = ar_gzjl;
    }

    public Long getAr_gl() {
        return ar_gl;
    }

    public void setAr_gl(Long ar_gl) {
        this.ar_gl = ar_gl;
    }

    public String getAr_love() {
        return ar_love;
    }

    public void setAr_love(String ar_love) {
        this.ar_love = ar_love;
    }

    public String getAr_qq() {
        return ar_qq;
    }

    public void setAr_qq(String ar_qq) {
        this.ar_qq = ar_qq;
    }

}
