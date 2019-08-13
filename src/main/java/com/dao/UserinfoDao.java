package com.dao;

import com.entity.Userinfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserinfoDao {

    @Select("select * from userinfo where us_name=#{name}")
    public Userinfo UserLogin( String name);

    @Insert("insert into userinfo values(us_seq.nextval,#{us_name},#{us_password},#{ro_id.id},#{us_dep.id},#{us_pos.id})")
    public void add(Userinfo u);

    @Update("update userinfo  set us_name=#{us_name},us_password=#{us_password}," +
            "ro_id={ro_id.id},us_dep=#{us_dep.id},us_pos=#{us_pos.id} where ")
    public void mod(Userinfo userinfo);



    @ResultMap("us")
    @Select("select * from (select u.*,rownum r from(select * from userinfo order by us_id)u)s " +
            "where s.r between (#{0}-1)*#{1} and #{0}*#{1}")
    public List<Userinfo> getAll(int page,int pagesize);

    @Results(value = {
            @Result(column = "us_pos",property = "us_pos",one = @One(select = "com.dao.PositionDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "us_dep",property = "us_dep",one = @One(select = "com.dao.DepartmentDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "ro_id",property = "ro_id",one = @One(select = "com.dao.RoleDao.getOne",fetchType = FetchType.EAGER))
    },id = "us")
    @Select("select * from userinfo where us_id =#{id}")
    public Userinfo getOne(Long id);

    @Select("select count(1) from userinfo")
    public Long getN(Long id);
}
