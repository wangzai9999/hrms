package com.biz;

import com.dao.RoleDao;
import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void add(String name, Integer[] id) {
        PowersBiz biz=new PowersBizImpl();
        List list=new ArrayList();
        for (int i=0;i<id.length;i++) {
            list.add(biz.getById(id[i]));
        }
        Role role=new Role();
        role.setRo_name(name);
        role.setList(list);

        dao.add(role);
    }


    @Override
    public void del(Long id) {
        dao.del(id);
    }
}
