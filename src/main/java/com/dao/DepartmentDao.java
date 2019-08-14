package com.dao;

import com.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepartmentDao {

    @Insert("insert into department values(de_seq.nextval,#{de_name},#{de_fa.id})")
    public  void add(Department department);

    @Delete("delete from department where de_id=#{id}")
    public void del (Long id);

    @Update("update department set de_name=#{de_name},de_fa=#{de_fa.de_id},de_man={de_man.us_id}  where de_id=#{de_id} ")
    public void mod(Department department);

    @Select("select * from department where de_id=#{id}")
    public Department getOne(Long id);

    @Select("select * from department")
    public List<Department> getAll();

}
