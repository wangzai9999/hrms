package com.web;

import com.biz.TrainingInfoBiz;
import com.entity.TrainingInfo;
import com.util.PageBean;
import com.util.TrainingInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tra")
public class TrainingInfoAction {

    @Autowired
    private TrainingInfoBiz biz;

    public TrainingInfoBiz getBiz() {
        return biz;
    }

    public void setBiz(TrainingInfoBiz biz) {
        this.biz = biz;
    }

    @RequestMapping("/get")
    public ModelAndView get(Long id, ModelAndView mv){
        TrainingInfo trainingInfo=biz.getOne(id);
        mv.setViewName("tra/mod");
        mv.addObject("tra",trainingInfo);
        return mv;
    }

    @RequestMapping("/getall")
    @ResponseBody
    public PageBean getAll(@RequestParam(defaultValue = "1") int page, TrainingInfoParam param){
        if (page<1) page=1;
        return biz.getAllByPage(page,param);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<TrainingInfo> getAll(){
        return biz.getAll();
    }

    @RequestMapping("/mod")
    @ResponseBody
    public String mod(TrainingInfo trainingInfo){
        biz.mod(trainingInfo);
        return "1";
    }

    @RequestMapping("/add")
    public String add(@Valid TrainingInfo trainingInfo, BindingResult result, Model model){
        if (result.hasErrors()){
            List<FieldError> list=result.getFieldErrors();
            for (FieldError er:list){
                model.addAttribute(er.getField(),er.getDefaultMessage());
            }
            model.addAttribute("tra",trainingInfo);
            return "tra/add";

        }else {
            biz.add(trainingInfo);
            return "tra/list";
        }
    }

    @RequestMapping("/del")
    public String del(Long id){
        biz.del(id);
        return "tra/list";
    }
}
