package com.web;


import com.biz.DepartmentBiz;
import com.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @RequestMapping("/add")
    @ResponseBody
    public String add(Department dep){
        System.out.println(dep.toString());
        biz.add(dep);
        return "1";
    }
    @RequestMapping("/mod")
    @ResponseBody
    public String mod(Department dep){
        System.out.println(dep.toString());
        biz.mod(dep);
        return "1";
    }

    @RequestMapping("/get/{gid}")
    public ModelAndView getOne(@RequestParam(value = "gid") Long id,ModelAndView mv){
        Department department=biz.getOne(id);
        mv.setViewName("dep/mod");
        mv.addObject("dep",department);
        return mv;
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(Long id){
        biz.del(id);
        return "1";
    }
    @ResponseBody
    @RequestMapping("/getbyid")
    public Department getOneById(Long did){
       return biz.getOne(did);
    }

    @ResponseBody
    @RequestMapping("/getdepnum")
     public ModelAndView getDepNum(ModelAndView mv){
        List<Map<String,Integer>> li=biz.getDepNum();
        List<String> xkey=new ArrayList<String>();
        List<String> yval=new ArrayList<String>();

        for (Map<String,Integer> map:li){
            Set<String> kset=map.keySet();

                for (String s:kset){
                    if (s.equals("ENUM")){
                        yval.add(map.get(s)+"");
                    }
                    if (s.equals("DNAME")){
                        String s2="'"+map.get(s)+"'";

                        xkey.add(s2);
                    }


                }

        }


        mv.addObject("xk",xkey);
        mv.addObject("yv",yval);
        mv.setViewName("department/deptnum");
        return mv;
     }


}
