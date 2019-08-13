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
    public Userinfo UserLogin(String name, String password) {
        return dao.UserLogin(name,password);
    }
}
