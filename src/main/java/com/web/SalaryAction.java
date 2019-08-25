package com.web;

import com.biz.SalaryBiz;
import com.entity.Salary;
import com.entity.Userinfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sl")
public class SalaryAction {

    @Autowired
    private SalaryBiz biz;

    public SalaryBiz getBiz() {
        return biz;
    }

    public void setBiz(SalaryBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/add")
    public String add(Long usid){
        Salary sl = new Salary();
        sl.setSl_ud_id(new Userinfo(usid));
        Double sals = biz.getSalByUsPos(usid);
        Long avsr = biz.getAvByUs(usid);
        sl.setSl_sal((long) (sals/100*(avsr.doubleValue())));
        biz.add(sl);
        return "sl/list";
    }
    @RequestMapping("/getall")
    @ResponseBody()
    public PageBean getAll(@RequestParam(defaultValue = "1")int page){
        return biz.getAllByPage(page);
    }
    @RequestMapping("/getonebyus")
    @ResponseBody
    public String getOneByUs(Long usid){
        Salary sa = biz.getOneByUsid(usid);
        if(sa!=null){
            return "1";
        }
        return "0";
    }

}
