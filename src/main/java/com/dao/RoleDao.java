package com.dao;

import com.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from role")
    public List<Role> getAllRole();

    @Select("select * from role where ro_id=#{id}")
    public Role getOne(Long id);

}
