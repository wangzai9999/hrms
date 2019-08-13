package com.biz;

import com.dao.RoleDao;
import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleBizImpl implements RoleBiz{

    @Autowired
    private RoleDao dao;

    public RoleDao getDao() {
        return dao;
    }

    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Role> getAllRole() {
        return dao.getAllRole();
    }

    @Override
    public Role getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public void add(Role r) {
        dao.add(r);
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }
}
