package com.biz;

import com.dao.ArchivesDao;
import com.dao.UserinfoDao;
import com.entity.Userinfo;
import com.util.PageBean;
import com.util.UserinfoParam;
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
    @Autowired
    private ArchivesDao adao;

    public ArchivesDao getAdao() {
        return adao;
    }

    public void setAdao(ArchivesDao adao) {
        this.adao = adao;
    }

    @Override
    public Userinfo UserLogin(String name) {
        return dao.UserLogin(name);
    }

    @Override
    public Userinfo getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public void add(Userinfo u) {
        dao.add(u);
    }

    @Override
    public void del(Long id) {
        adao.del(id);
        dao.del(id);
    }

    @Override
    public void mod(Userinfo userinfo) {
        dao.mod(userinfo);
    }

    @Override
    public PageBean getAll(int page,UserinfoParam param) {
        PageBean pageBean=new PageBean();
        pageBean.setTotalNum(dao.rowCount(param).intValue());
        if (page>pageBean.getTotalPage()) page=pageBean.getTotalPage();
        pageBean.setCurrpage(page);
        pageBean.setList(dao.getAll(page,pageBean.getPageSize(),param));
        return pageBean;
    }

    @Override
    public Long getNowID() {
        return dao.getNowID();
    }
}
