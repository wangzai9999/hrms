package com.biz;

import com.entity.Userinfo;
import com.util.PageBean;

public interface UserinfoBiz {

    public Userinfo UserLogin(String name);
    public Userinfo getOne(Long id);

    public PageBean getAll(int page,int pagesize);

}
