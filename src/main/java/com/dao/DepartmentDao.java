package com.dao;

import com.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentDao {


    public  void add(Department department);

    @Delete("delete from department where de_id=#{id}")
    public void del (Long id);


    public void mod(Department department);


    public Department getOne(Long id);



    public List<Department> getAll();

}
