package com.web;

import com.biz.UserinfoBiz;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("login")
    public String UserLogin(String name, String password, HttpServletRequest req){
        Userinfo u = biz.UserLogin(name,password);
        if(u!=null){
            req.getSession().setAttribute("loger",u);
            return "";
        }else{
            return "";
        }
    }

}
