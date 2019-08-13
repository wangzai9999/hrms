package com.dao;

import com.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("select * from role")
    public List<Role> getAllRole();

    @Select("select * from role where ro_id=#{id}")
    public Role getOne(Long id);

    @Insert("insert into role values(ro_seq.nextval,#{ro_name})")
    public void add(Role r);

    @Delete(" begin " +
            " delete from role_power where r_id=#{id}; " +
            " delete from role where ro_id=#{id};" +
            " end;")
    public void del(Long id);

}
