package com.web;

import com.biz.AchievementsBiz;
import com.entity.Achievements;
import com.entity.Userinfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/av")
public class AchievementsAction {

    @Autowired
    private AchievementsBiz biz;

    public AchievementsBiz getBiz() {
        return biz;
    }

    public void setBiz(AchievementsBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/add")
    public String add(Achievements av, HttpServletRequest req){
        Userinfo u = (Userinfo) req.getSession().getAttribute("loger");
        av.setAv_man(u);
        Long days = av.getAv_day_score();
        av.setAv_day_score((long) (days*100/300*6));
        av.setAv_man_score((long)(av.getAv_man_score()*0.4));
        av.setAv_ym(new Date());
        av.setAv_sr(av.getAv_day_score()+av.getAv_man_score());
        biz.add(av);
        return "achs/list";
    }

    @RequestMapping("/getall")
    @ResponseBody
    public PageBean getAll(@RequestParam(defaultValue = "1") int page){
        return biz.getAll(page);
    }

}
