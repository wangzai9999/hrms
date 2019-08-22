package com.web;

import com.biz.PowersBiz;
import com.entity.Powers;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @RequestMapping("/list")
    @ResponseBody
    public List<Powers> list()
    {
        return biz.getAll();
    }

    @RequestMapping("/add")
    public void add(Powers power,HttpServletResponse response) throws IOException
    {
        biz.add(power);
        response.getWriter().print("1");
    }

    @RequestMapping("/mod")
    public void mod(String name ,long id,HttpServletResponse response) throws IOException
    {
        System.out.println(name+","+id);
        biz.mod(name, id);
        response.getWriter().print("1");
    }


    @RequestMapping("/modPar")
    public void modPar(long praid ,long id,HttpServletResponse response) throws IOException{

        biz.modPar(praid, id);
        response.getWriter().print("1");
    }

    @RequestMapping("/del")
    public void del(long did,HttpServletResponse response) throws IOException
    {

        biz.del(did);
        response.getWriter().print("1");
    }

}
