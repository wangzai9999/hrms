package com.biz;

import com.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentBiz {
    public  void add(Department department);
    public void del (Long id);
    public void mod(Department department);

    public Department getOne(Long id);

    public List<Department> getAll();

    public List<Map<String,Integer>> getDepNum();
}
