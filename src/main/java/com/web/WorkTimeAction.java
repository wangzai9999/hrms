package com.web;

import com.biz.WorkTimeBiz;
import com.entity.Userinfo;
import com.entity.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/wt")
public class WorkTimeAction {

    @Autowired
    private WorkTimeBiz biz;

    public WorkTimeBiz getBiz() {
        return biz;
    }

    public void setBiz(WorkTimeBiz biz) {
        this.biz = biz;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(WorkTime wt, HttpServletRequest req){
        Userinfo us= (Userinfo) req.getSession().getAttribute("loger");
        wt.setUs_id(us);
        Calendar nt =Calendar.getInstance();
        int nh=nt.get(Calendar.HOUR_OF_DAY);
        String st="正常";
        System.out.println(nh);
        if(nh>=9){
           st="迟到";
        }

        wt.setWt_bstatus(st);
        biz.add(wt);
        return "上班签到成功！";
    }
    @ResponseBody
    @RequestMapping("/mod")
    public String mod(WorkTime wt,HttpServletRequest req){
        Userinfo us= (Userinfo) req.getSession().getAttribute("loger");
        wt=biz.getWtId(us.getUs_id());
        System.out.println(wt.toString());
        Calendar nt =Calendar.getInstance();
        int nh=nt.get(Calendar.HOUR_OF_DAY);
        String est="正常";
        if(nh<=18){
            est="早退";
        }
        wt.setUs_id(us);
        wt.setWt_estatus(est);
        biz.mod(wt);
        return "下班签退成功！";

    }


}
