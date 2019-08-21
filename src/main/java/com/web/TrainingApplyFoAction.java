package com.web;

import com.biz.TrainingApplyFoBiz;
import com.biz.TrainingInfoBiz;
import com.entity.TrainingApplyFo;
import com.entity.TrainingInfo;
import com.entity.Userinfo;
import com.util.PageBean;
import com.util.TrainingApplyFoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/taf")
public class TrainingApplyFoAction {

    @Autowired
    private TrainingApplyFoBiz biz;

    @Autowired
    private TrainingInfoBiz trz;

    public TrainingApplyFoBiz getBiz() {
        return biz;
    }

    public void setBiz(TrainingApplyFoBiz biz) {
        this.biz = biz;
    }

    public TrainingInfoBiz getTrz() {
        return trz;
    }

    public void setTrz(TrainingInfoBiz trz) {
        this.trz = trz;
    }

    @InitBinder
    public void convertTime(WebDataBinder binder){
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(ss,true));
    }

    @RequestMapping("/add")
    public String add(Long id, HttpServletRequest request){
        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("loger");
        TrainingApplyFo trainingApplyFo=new TrainingApplyFo();
        trainingApplyFo.setTf_tr_id(trz.getOne(id));
        trainingApplyFo.setTf_us_id(userinfo);
        biz.add(trainingApplyFo);
        return "taf/list";
    }

    @RequestMapping("/del")
    public String del(Long id){
        biz.del(id);
        return "taf/list";
    }

    @RequestMapping("/mod")
    @ResponseBody
    public String mod(TrainingApplyFo trainingApplyFo){
        biz.mod(trainingApplyFo);

        return "1";
    }

    @RequestMapping("/getOne")
    public ModelAndView getOne(Long id,ModelAndView mv){
        TrainingApplyFo trainingApplyFo=biz.getOne(id);
        mv.addObject("tra",trainingApplyFo);
        mv.setViewName("taf/mod");
        return mv;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public PageBean getAll(@RequestParam(defaultValue = "1") int page, TrainingApplyFoParam param){
        if (page<1) page=1;
        PageBean pageBean=biz.getAllByParam(page,param);
        return pageBean;
    }

    @RequestMapping("/cha")
    @ResponseBody
    public TrainingApplyFo cha(HttpServletRequest request){
        Userinfo u= (Userinfo) request.getSession().getAttribute("loger");
        return biz.getByTfUs(u.getUs_id());
    }

    @RequestMapping("/shen")
    public ModelAndView shen(Long id,ModelAndView mv){
        TrainingApplyFo fo=biz.getOne(id);
        mv.setViewName("taf/shen");
        mv.addObject("mv",fo);
        return mv;
    }

}
