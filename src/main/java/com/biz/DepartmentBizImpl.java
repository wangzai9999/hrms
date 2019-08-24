package com.biz;

import com.dao.DepartmentDao;
import com.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentBizImpl implements DepartmentBiz {

    @Autowired
    private DepartmentDao dao;

    public DepartmentDao getDao() {
        return dao;
    }

    public void setDao(DepartmentDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Department department) {
        dao.add(department);
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }

    @Override
    public void mod(Department department) {
        dao.mod(department);
    }

    @Override
    public Department getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Map<String, Integer>> getDepNum() {
        return dao.getDepNum();
    }
}
