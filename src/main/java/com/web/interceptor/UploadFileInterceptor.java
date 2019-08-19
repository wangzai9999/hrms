package com.web.interceptor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UploadFileInterceptor extends HandlerInterceptorAdapter {

    List<String> list= Arrays.asList(new String[]{"jpg","jpeg","png","gif"});
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(request instanceof MultipartHttpServletRequest){
           MultipartHttpServletRequest req= (MultipartHttpServletRequest) request;
           List<MultipartFile> li=  req.getFiles("file");
           for (MultipartFile file:li){
               String fname=file.getOriginalFilename();
               String fsuffix=fname.substring(fname.indexOf(".")+1);
               boolean flag=list.contains(fsuffix);
               if(!flag){
                   response.setContentType("text/html;charset=utf-8");
                   response.getWriter().print("<script>alert('不支持图片以外的文件格式！;');history.go(-1)</script>");
                   return false;
               }


           }
           return true;



       }




        return false;
    }
}
