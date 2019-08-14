package com.web;

import com.biz.PowersBiz;
import com.entity.Powers;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/powers")
public class PowersAction {

    @Autowired
    private PowersBiz biz;

    public PowersBiz getBiz() {
        return biz;
    }

    public void setBiz(PowersBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public List<Powers> getAllByRole(HttpServletRequest req){
        Userinfo u = (Userinfo) req.getSession().getAttribute("loger");
        return biz.getAllByRole(u.getRo_id().getRo_id());
    }

}
