package com.dao;

import com.entity.Salary;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SalaryDao {

    @Insert("insert into salary values(sl_seq.nextval,#{sl_usid},#{sl_sal})")
    public void add(Salary sl);

    @Results(
            @Result(property = "sl_usid",column = "sl_usid",one=@One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    )
    @Select("select s.*,rownum r from salary s) x where x.r>(#{0}-1)*#{1} and x.r<=#{0}*#{1}")
    public List<Salary> getAll(int page,int pagesize);

    @Select("select count(1) from salary")
    public Long getCount();

}
