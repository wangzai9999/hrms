package com.biz;

import com.dao.UserinfoDao;
import com.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoBizImpl implements UserinfoBiz{

    @Autowired
    private UserinfoDao dao;

    public UserinfoDao getDao() {
        return dao;
    }

    public void setDao(UserinfoDao dao) {
        this.dao = dao;
    }

    @Override
    public Userinfo UserLogin(String name) {
        return dao.UserLogin(name);
    }

    @Override
    public Userinfo getOne(Long id) {
        return dao.getOne(id);
    }
}
