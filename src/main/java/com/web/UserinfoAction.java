package com.web;

import com.biz.UserinfoBiz;
import com.entity.Userinfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                return "index";
            } else {
                return "login";
            }
        } else {
            return "login";
        }
    }

    @RequestMapping("/get")
    @ResponseBody
    public Userinfo get(Long id){
       return biz.getOne(id);
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageBean list(@RequestParam(defaultValue = "1") int page){
        PageBean pageBean=biz.getAll(page);
        return pageBean;
    }


}
