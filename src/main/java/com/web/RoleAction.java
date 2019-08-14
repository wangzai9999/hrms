package com.web;

import com.biz.RoleBiz;
import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleAction {

    @Autowired
    private RoleBiz biz;

    public RoleBiz getBiz() {
        return biz;
    }

    public void setBiz(RoleBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public List<Role> getAll(){
        return biz.getAllRole();
    }

    @RequestMapping("/getone")
    public String getOne(Long id, Model m){
        Role r = biz.getOne(id);
        m.addAttribute("r",r);
        return "";
    }

    @RequestMapping("/add")
    public String add(Role r){
        biz.add(r);
        return "";
    }
    @RequestMapping("/del")
    public String del(Long id){
        biz.del(id);
        return "";
    }
}
