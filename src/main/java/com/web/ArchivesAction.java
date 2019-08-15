package com.web;

import com.biz.ArchivesBiz;
import com.entity.Archives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/arc")
public class ArchivesAction {


    @Autowired
    private ArchivesBiz biz;

    public ArchivesBiz getBiz() {
        return biz;
    }

    public void setBiz(ArchivesBiz biz) {
        this.biz = biz;
    }



    @RequestMapping("/getall")
    @ResponseBody
    public List<Archives> getAll(){
        return biz.getAll();
    }

    @RequestMapping("/getOne")
    public ModelAndView getOne(Long id,ModelAndView mv){
        Archives archives=biz.getOne(id);
        mv.setViewName("arc/mod");
        mv.addObject("arc",archives);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Archives archives){
        biz.add(archives);
        return "1" ;
    }

    @RequestMapping("/mod")
    @ResponseBody
    public String mod(Archives archives){
        biz.mod(archives);
        return "1" ;
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Long  id){
        biz.del(id);
        return "1" ;
    }



}
