package com.web;

import com.biz.ResumeBiz;
import com.entity.Resume;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/resume")
public class ResumeAction {

    @Autowired
    private ResumeBiz biz;

    public ResumeBiz getBiz() {
        return biz;
    }

    public void setBiz(ResumeBiz biz) {
        this.biz = biz;
    }

    @InitBinder
    public void convertTime(WebDataBinder binder){
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(ss,true));
    }

    @RequestMapping("getall")
    @ResponseBody
    public PageBean getAllByPage(@RequestParam(defaultValue = "1") int page){
        return biz.getAllByPage(page);
    }

    @RequestMapping("/add")
    public String add(Resume re, MultipartFile file, HttpServletRequest req){
        re.setRe_time(new Date());
        String filename = file.getOriginalFilename();
        String path = req.getServletContext().getRealPath("files/file");
        re.setRe_url("files/file/"+filename);
        File f = new File(path+"\\"+filename);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        biz.addResume(re);
        return "resume/list";
    }

    @RequestMapping("/del")
    public String del(Long re_id){
        biz.del(re_id);
        return "resume/list";
    }

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(String filename, HttpServletRequest req, HttpServletResponse res){
        String path = req.getServletContext().getRealPath(filename);
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(new File(path)));
            res.setContentType("application/octet-stream");
            String headval="attachment;";
            headval += " filename=\"" + encodeURIComponent(filename) +"\";";
            headval += " filename*=utf-8''" + encodeURIComponent(filename);

            res.addHeader("Content-Disposition", headval);
            BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
            int len = 0;
            while((len=is.read())!= -1){
                out.write(len);
                out.flush();
            }
            is.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String encodeURIComponent(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
