package com.dao;

import com.entity.Userinfo;
import com.util.UserinfoParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserinfoDao {

    @Select("select * from userinfo where us_name=#{name}")
    public Userinfo UserLogin( String name);

    @Insert("insert into userinfo values(us_seq.nextval,#{us_name},#{us_password},#{ro_id.ro_id},#{us_dep.de_id},#{us_pos.pos_id})")
    public void add(Userinfo u);

    @Update("update userinfo  set us_name=#{us_name},us_password=#{us_password}," +
            "ro_id={ro_id.id},us_dep=#{us_dep.id},us_pos=#{us_pos.id} where ")
    public void mod(Userinfo userinfo);

    @Delete("delete from userinfo where us_id=#{id}")
    public void  del(Long id);

    @ResultMap("us")
    @Select("<script>select * from (select u.*,rownum r from(select * from userinfo " +
            "<where> <if test='param3.name!=null and param3.name!=\"\"'> and us_name like '%'||#{2.name}||'%'</if>" +
            " <if test='param3.ro_id!=null and param3.ro_id!=0'> and ro_id=#{2.ro_id} </if>" +
            " <if test='param3.de_id!=null and param3.de_id!=0'> and us_dep=#{2.de_id}</if>" +
            " <if test='param3.pos_id!=null and param3.pos_id!=0'> and us_pos=#{2.pos_id} </if> " +
            " </where> order by us_id)u)s " +
            "where s.r>(#{0}-1)*#{1} and  s.r<![CDATA[<=]]>#{0}*#{1}</script>")
    public List<Userinfo> getAll(int page, int pagesize,UserinfoParam param);

    @Results(value = {
            @Result(column = "us_pos",property = "us_pos",one = @One(select = "com.dao.PositionDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "us_dep",property = "us_dep",one = @One(select = "com.dao.DepartmentDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "ro_id",property = "ro_id",one = @One(select = "com.dao.RoleDao.getOne",fetchType = FetchType.EAGER))
    },id = "us")
    @Select("select * from userinfo where us_id =#{id}")
    public Userinfo getOne(Long id);

    @Select("<script>select count(1) from userinfo " +
            "<where> <if test='name!=null and name!=\"\"'> and us_name like '%'||#{name}||'%'</if>" +
            " <if test='ro_id!=null and ro_id!=0'> and ro_id=#{ro_id} </if>" +
            " <if test='de_id!=null and de_id!=0'> and us_dep=#{de_id}</if>" +
            " <if test='pos_id!=null and pos_id!=0'> and us_pos=#{pos_id} </if> " +
            "</where></script> ")
    public Long rowCount(UserinfoParam param);
}
