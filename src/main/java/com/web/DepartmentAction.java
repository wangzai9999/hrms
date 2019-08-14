package com.web;


import com.biz.DepartmentBiz;
import com.entity.Department;
import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepartmentAction {

    @Autowired
    public DepartmentBiz biz;

    public DepartmentBiz getBiz() {
        return biz;
    }

    public void setBiz(DepartmentBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public List<Department> getAll(){
        return biz.getAll();
    }


}
