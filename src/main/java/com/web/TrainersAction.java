package com.web;

import com.biz.TrainersBiz;
import com.entity.Trainers;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/trs")
public class TrainersAction {

    @Autowired
    private TrainersBiz biz;

    public TrainersBiz getBiz() {
        return biz;
    }

    public void setBiz(TrainersBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/add")
    public String add(Trainers trainers){
        biz.add(trainers);
        return "1";
    }

    @RequestMapping("/mod")
    public String mod(Trainers trainers){
        biz.mod(trainers);
        return "trs/list";
    }

    @RequestMapping("/del")
    public String del(Long  id){
        biz.del(id);
        return "1";
    }

    @RequestMapping("getall")
    @ResponseBody
    public PageBean getall(){
        return biz.getAll();
    }

    @RequestMapping("getOne")
    public ModelAndView getOne(Long id,ModelAndView mv){
        mv.setViewName("trs/mod");
        Trainers trainers=biz.getOne(id);
        mv.addObject("trs",trainers);
        return mv;
    }

}
