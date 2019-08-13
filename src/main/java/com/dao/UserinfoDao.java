package com.dao;

import com.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoDao {

    @Select("select * from userinfo where us_name=#{name} and us_password=#{password}")
    public Userinfo UserLogin(@Param("name") String name,@Param("password") String password);

}
