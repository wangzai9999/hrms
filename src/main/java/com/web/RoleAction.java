package com.web;

import com.biz.RoleBiz;
import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/queryall")
    @ResponseBody
    public List<Role> getAllRole(){
        return biz.getAllRole();
    }

}
