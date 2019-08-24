package com.web;

import com.biz.TrainingInfoBiz;
import com.entity.TrainingInfo;
import com.util.PageBean;
import com.util.TrainingInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tra")
public class TrainingInfoAction {

    @Autowired
    private TrainingInfoBiz biz;

    public TrainingInfoBiz getBiz() {
        return biz;
    }

    public void setBiz(TrainingInfoBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/get")
    public ModelAndView get(Long id, ModelAndView mv){
        TrainingInfo trainingInfo=biz.getOne(id);
        mv.setViewName("tra/mod");
        mv.addObject("tra",trainingInfo);
        return mv;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public PageBean getAll(@RequestParam(defaultValue = "1") int page, TrainingInfoParam param){
        if (page<1) page=1;
        return biz.getAllByPage(page,param);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<TrainingInfo> getAll(){
        return biz.getAll();
    }

    @RequestMapping("/mod")
    @ResponseBody
    public String mod(TrainingInfo trainingInfo){
        biz.mod(trainingInfo);
        return "1";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(TrainingInfo trainingInfo){
        biz.add(trainingInfo);
        return "1";
    }

    @RequestMapping("/del")
    public String del(Long id){
        biz.del(id);
        return "tra/list";
    }
}
