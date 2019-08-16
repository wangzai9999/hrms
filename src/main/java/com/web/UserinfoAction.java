package com.web;

import com.biz.UserinfoBiz;
import com.entity.Userinfo;
import com.util.PageBean;
import com.util.UserinfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserinfoAction {

    @Autowired
    private UserinfoBiz biz;

    public UserinfoBiz getBiz() {
        return biz;
    }

    public void setBiz(UserinfoBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/login")
    public String UserLogin(String name, String password, HttpServletRequest req) {
        Userinfo u = biz.UserLogin(name);
        if (u != null) {
            if (u.getUs_password().equals(password)) {
                req.getSession().setAttribute("loger", u);
                return "user/list";
            } else {
                return "login";
            }
        } else {
            return "login";
        }
    }

    @RequestMapping("/get")
    public ModelAndView get(Long id,ModelAndView mv){
        Userinfo userinfo=biz.getOne(id);
        mv.setViewName("user/mod");
        mv.addObject("us",userinfo);
        return mv;
    }

    @RequestMapping("/getone")
    @ResponseBody
    public Userinfo getOneById(Long usid){
        Userinfo userinfo=biz.getOne(usid);
        return userinfo;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public PageBean getAll(@RequestParam(defaultValue = "1") int page,UserinfoParam param){
        if (page<1) page=1;
        return biz.getAll(page,param);
    }

    @RequestMapping("/mod")
    @ResponseBody
    public String mod(Userinfo userinfo){
        biz.mod(userinfo);
        return "1";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(Userinfo userinfo){
        biz.add(userinfo);
        Long a=biz.getNowID();
        return ""+a;
    }

    @RequestMapping("/del")
    public String del(Long id){
        biz.del(id);
        return "user/list";
    }


}
