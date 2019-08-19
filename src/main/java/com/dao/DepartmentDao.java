package com.dao;

import com.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentDao {


    public  void add(Department department);

    @Delete("delete from department where de_id=#{id}")
    public void del (Long id);

    @Update("update department set de_name=#{de_name},de_fa=#{de_fa.de_id},de_man={de_man.us_id}  where de_id=#{de_id} ")
    public void mod(Department department);


    public Department getOne(Long id);



    public List<Department> getAll();

}
