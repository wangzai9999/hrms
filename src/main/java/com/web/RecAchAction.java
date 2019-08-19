package com.web;

import com.biz.RecAchBiz;
import com.entity.RecAch;
import com.entity.Userinfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ach")
public class RecAchAction {

    @Autowired
    private RecAchBiz biz;

    public RecAchBiz getBiz() {
        return biz;
    }

    public void setBiz(RecAchBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/add")
    public String add(RecAch ach, HttpServletRequest req){
        ach.setAch_auditor((Userinfo)req.getSession().getAttribute("loger"));
        biz.add(ach);
        return "ach/list";
    }
    @RequestMapping("/del")
    public String del(Long ach_id){
        biz.del(ach_id);
        return "ach/list";
    }
    @RequestMapping("/getone")
    public String getOne(Long ach_id){
        biz.getOne(ach_id);
        return "ach/update";
    }
    @RequestMapping("/update")
    public String Update(RecAch ach){
        biz.update(ach);
        return "ach/list";
    }
    @RequestMapping("/getall")
    @ResponseBody
    public PageBean getAll(@RequestParam(defaultValue = "1") int page){
        return biz.getAllByPage(page);
    }

}
