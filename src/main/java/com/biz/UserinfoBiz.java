package com.biz;

import com.entity.Userinfo;
import com.util.PageBean;
import com.util.UserinfoParam;

import java.util.List;

public interface UserinfoBiz {

    public Userinfo UserLogin(String name);
    public Userinfo getOne(Long id);
    public void add(Userinfo u);
    public void  del(Long id);
    public void mod(Userinfo userinfo);
    public PageBean getAll(int page,UserinfoParam param);
    public Long getNowID();

    public List<Userinfo> getAllNotDm();
    public List<Userinfo> getAllByDep(Long id);

}
