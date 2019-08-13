package com.web;

import com.biz.PositionBiz;
import com.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/getall")
    public List<Position> getAll(){
        return biz.getAll();
    }

    @RequestMapping("/add")
    public String add(Position p){
        biz.add(p);
        return "";
    }

    @RequestMapping("/del")
    public String del(Long id){
       biz.del(id);
       return "";
    }
    @RequestMapping("/mod")
    public String mod(Position p){
        biz.mod(p);
        return "";
    }

    @RequestMapping("getone")
    public String getOne(Long id){
        return "";
    }

}
