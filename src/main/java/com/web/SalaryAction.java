package com.web;

import com.biz.SalaryBiz;
import com.entity.Salary;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sl")
public class SalaryAction {

    @Autowired
    private SalaryBiz biz;

    public SalaryBiz getBiz() {
        return biz;
    }

    public void setBiz(SalaryBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/add")
    public String add(Long usid){
        Salary sl = new Salary();
        sl.setSl_ud_id(new Userinfo(usid));
        biz.add(sl);
        return "sl/list";
    }

}
