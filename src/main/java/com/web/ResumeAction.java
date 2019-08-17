package com.web;

import com.biz.ResumeBiz;
import com.entity.Resume;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resume")
public class ResumeAction {

    @Autowired
    private ResumeBiz biz;

    public ResumeBiz getBiz() {
        return biz;
    }

    public void setBiz(ResumeBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("getall")
    @ResponseBody
    public PageBean getAllByPage(@RequestParam(defaultValue = "1") int page){
        return biz.getAllByPage(page);
    }

    @RequestMapping("/add")
    public String add(Resume re){
        biz.addResume(re);
        return "resume/list";
    }

    @RequestMapping("/del")
    public String del(Long id){
        biz.del(id);
        return "resume/list";
    }

}
