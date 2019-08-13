package com.biz;

import com.entity.Userinfo;

public interface UserinfoBiz {

    public Userinfo UserLogin(String name);
    public Userinfo getOne(Long id);

}
