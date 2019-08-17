package com.web;

import com.biz.EngageMajorReleaseBiz;
import com.entity.EngageMajorRelease;
import com.entity.Userinfo;
import com.util.EngageParam;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/en")
public class EngageMajorReleaseAction {

    @Autowired
    private EngageMajorReleaseBiz biz;

    public EngageMajorReleaseBiz getBiz() {
        return biz;
    }

    public void setBiz(EngageMajorReleaseBiz biz) {
        this.biz = biz;
    }

    @InitBinder
    public void convertTime(WebDataBinder binder){
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(ss,true));
    }

    @RequestMapping("/getall")
    @ResponseBody
    public PageBean getAllByPage(@RequestParam(defaultValue = "1") int page, EngageParam enp){
        System.out.println(enp.getMinaccount());
        if(enp==null)enp=new EngageParam();
        return biz.getAllByPage(page,enp);
    }

    @RequestMapping("/getone")
    public String getOne(Long en_id, Model m){
        EngageMajorRelease en = biz.getOne(en_id);
        m.addAttribute("en",en);
        return "en/mod";
    }

    @RequestMapping("/add")
    public String add(EngageMajorRelease en, HttpServletRequest req){
        en.setEn_creater((Userinfo) req.getSession().getAttribute("loger"));
        biz.add(en);
        return "en/list";
    }

    @RequestMapping("/del")
    public String del(Long en_id){
        biz.del(en_id);
        return "en/list";
    }

    @RequestMapping("/update")
    public String update(EngageMajorRelease en){
        biz.update(en);
        return "en/list";
    }

}
