package com.dao;

import com.entity.Salary;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SalaryDao {

    @Insert("insert into salary values(sl_seq.nextval,#{sl_ud_id.us_id},#{sl_sal})")
    public void add(Salary sl);

    @Results(
            @Result(property = "sl_ud_id",column = "sl_ud_id",one=@One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    )
    @Select("select * from (select s.*,rownum r from salary s) x where x.r>(#{0}-1)*#{1} and x.r<=#{0}*#{1}")
    public List<Salary> getAll(int page,int pagesize);

    @Select("select count(1) from salary")
    public Long getCount();

    @Select("select s.sa_totalmoney from userinfo u,salary_standard s where u.us_pos=s.sa_pos and u.us_id=#{usid}")
    public Double getSalByUsPos(Long usid);

    @Select("select a.av_sr from userinfo u,achievements a where u.us_id=a.us_id and u.us_id=#{usid}")
    public Long getAvByUs(Long usid);

    @Select("select * from salary where sl_ud_id=#{usid}")
    public Salary getOneByUsid(Long usid);

}
