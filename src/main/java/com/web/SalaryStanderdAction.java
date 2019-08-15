package com.web;

import com.biz.SalaryStanderdBiz;
import com.biz.SalaryStanderdDetailedBiz;
import com.entity.SalaryStanderd;
import com.entity.SalaryStanderdDetailed;
import com.entity.Userinfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/salt")
public class SalaryStanderdAction {
    @Autowired
    private SalaryStanderdBiz biz;
    @Autowired
    private SalaryStanderdDetailedBiz dbiz;

    public SalaryStanderdDetailedBiz getDbiz() {
        return dbiz;
    }

    public void setDbiz(SalaryStanderdDetailedBiz dbiz) {
        this.dbiz = dbiz;
    }

    public SalaryStanderdBiz getBiz() {
        return biz;
    }

    public void setBiz(SalaryStanderdBiz biz) {
        this.biz = biz;
    }
    @ResponseBody
    @RequestMapping("/getall")
    public ModelAndView getAll(@RequestParam(defaultValue = "1") int page,ModelAndView mv){
        mv.addObject("pb",biz.getAll(page));
        mv.setViewName("salary/list");
       return mv;
    }

    @RequestMapping("/addsd")
    public String addSalDetail(SalaryStanderdDetailed ssd,HttpServletRequest req){
        List<SalaryStanderdDetailed> list= (List<SalaryStanderdDetailed>) req.getSession().getAttribute("ssdlist");
        Double totalmoney = (Double) req.getSession().getAttribute("totalmoney");
        if(list==null||list.size()==0){list=new ArrayList<SalaryStanderdDetailed>(); }
        if(totalmoney==null){totalmoney=0d;}
        list.add(ssd);
        totalmoney=totalmoney+ssd.getSi_money();
        req.getSession().setAttribute("ssdlist",list);
        req.getSession().setAttribute("totalmoney",totalmoney);
        return "salary/add";

    }
    @RequestMapping("/delsd")
    public String delSalDetail(int index,HttpServletRequest req){
        List<SalaryStanderdDetailed> list= (List<SalaryStanderdDetailed>) req.getSession().getAttribute("ssdlist");
        Double totalmoney = (Double) req.getSession().getAttribute("totalmoney");
        SalaryStanderdDetailed ssd= list.get(index);
        totalmoney=totalmoney-ssd.getSi_money();
        list.remove(index);
        req.getSession().setAttribute("ssdlist",list);
        req.getSession().setAttribute("totalmoney",totalmoney);
        return "salary/add";
    }

    @RequestMapping("/addst")
    public String addSalLevel(SalaryStanderd sst,HttpServletRequest request){
        Userinfo us= (Userinfo) request.getSession().getAttribute("loger");
        sst.setList((List<SalaryStanderdDetailed>) request.getSession().getAttribute("ssdlist"));
        sst.setSa_totalmoney((Double) request.getSession().getAttribute("totalmoney"));
        sst.setSa_cre_id(us);
        biz.add(sst);
        request.getSession().removeAttribute("ssdlist");
        request.getSession().removeAttribute("totalmoney");
        return "redirect:getall.action";
    }

    @RequestMapping("/delst")
    public String delSalLevel(long delsaid){
        biz.del(delsaid);
        return "redirect:getall.action";
    }
    @RequestMapping("/getonest")
    public String getOne(long gsid, Model mo){
       mo.addAttribute("st",biz.getOne(gsid));
       return "salary/mod";
    }

    @RequestMapping("/modst")
    public String modSalLevel(SalaryStanderd modst){
        biz.mod(modst);
        return "redirect:getall.action";
    }


    @RequestMapping("/modaddsd")
    public String modSalAddDetail(long stid,SalaryStanderdDetailed ssdadd){
        dbiz.add(ssdadd,stid);
        return "redirect:getonest.action?gsid="+stid;
    }
    @RequestMapping("/moddelsd")
    public String modSaldelDetail(long stid,long ssdid){
        dbiz.del(ssdid,stid);
        return "redirect:getonest.action?gsid="+stid;
    }



}
