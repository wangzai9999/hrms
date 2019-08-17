package com.web;

import com.biz.ArchivesBiz;
import com.entity.Archives;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/arc")
public class ArchivesAction {


    @Autowired
    private ArchivesBiz biz;

    public ArchivesBiz getBiz() {
        return biz;
    }

    public void setBiz(ArchivesBiz biz) {
        this.biz = biz;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值

    }

    @RequestMapping("/getall")
    @ResponseBody
    public List<Archives> getAll(){
        return biz.getAll();
    }

    @RequestMapping("/getOne")
    public ModelAndView getOne(Long id, @RequestParam(defaultValue = "1") Long goid, ModelAndView mv){
       if(goid==null){
           Archives archives=biz.getOne(id);
           mv.setViewName("arcs/show");
           mv.addObject("arc",archives);

       }else if (goid==1){
           Archives archives=biz.getOne(id);
           mv.setViewName("arcs/mod");
           mv.addObject("arc",archives);
       }else {
           mv.setViewName("user/list");
       }


        return mv;
    }

    @RequestMapping("/add")
    public String add(Archives archives, MultipartFile file, HttpServletRequest req){
        String filename=file.getOriginalFilename();
        Userinfo us=(Userinfo) req.getSession().getAttribute("loger");
        archives.setAr_regist(us.getUs_name());
        String path=req.getServletContext().getRealPath("files/images");
        archives.setAr_photo("files/images/"+filename);
        System.out.println(path+"\\"+filename);                     //C:\softwarefile\git\hrms\src\main\webapp\files\images
        File newfile= new File(path+"\\"+filename);
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        biz.add(archives);
        return "user/list" ;
    }

    @RequestMapping("/mod")
    public String mod(Archives archives, MultipartFile file, HttpServletRequest req){
        Userinfo us=(Userinfo) req.getSession().getAttribute("loger");
        archives.setAr_change(us.getUs_name());
        if (file!=null){
            String filename=file.getOriginalFilename();

            String path=req.getServletContext().getRealPath("files/images");
            archives.setAr_photo("files/images/"+filename);
            File newfile= new File(path+"\\"+filename);
            try {
                file.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(archives.toString());
        biz.mod(archives);
        return "user/list" ;
    }

    @RequestMapping("/del")
    public String del(Long  id){
        biz.del(id);
        return "1" ;
    }



}
