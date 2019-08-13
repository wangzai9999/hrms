package com.web;

import com.biz.PositionBiz;
import com.entity.Position;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/pos")
public class PositionAction {

    @Autowired
    private PositionBiz biz;

    public PositionBiz getBiz() {
        return biz;
    }

    public void setBiz(PositionBiz biz) {
        this.biz = biz;
    }

    @ResponseBody
    @RequestMapping("/getall")
    public List<Position> getAll(){
        return biz.getAll();
    }


    @RequestMapping("/add")
    public String add(Position pos){
        biz.add(pos);
        return "1";
    }


    @RequestMapping("/del")
    public String del(Long id){
       biz.del(id);
       return "1";
    }

    @RequestMapping("/mod")
    public String mod(Position p){
        biz.mod(p);
        return "1";
    }


    @RequestMapping("/getone")
    public ModelAndView getOne(Long id,ModelAndView mv){
        Position p= biz.getOne(id);
        mv.addObject("position",p);
        mv.setViewName("1");
        return mv;
    }

}
