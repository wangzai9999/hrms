package com.dao;

import com.entity.RecAch;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RecAchDao {

    @Results({
            @Result(column = "ach_resid",property = "ach_resid",one=@One(select = "com.dao.ResumeDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "ach_auditor",property = "ach_auditor",one=@One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    })
    @Select("select * from (select ra.*,rownum r from rec_ach ra) x where x.r>(#{0}-1)*#{1} and x.r<=#{0}*#{1}")
    public List<RecAch> getAllByPage(int page,int pagesize);

    @Select("select count(1) from rec_ach")
    public Long getCount();

    @Insert("insert into rec_ach values(ach_seq.nextval,#{ach_resid.re_id},#{ach_exam},#{ach_interview},#{ach_auditor.us_id},#{ach_status},#{ach_comm})")
    public void add(RecAch ach);

    @Results({
            @Result(column = "ach_resid",property = "ach_resid",one=@One(select = "com.dao.ResumeDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "ach_auditor",property = "ach_auditor",one=@One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    })
    @Select("select * from rec_ach where ach_id=#{ach_id}")
    public RecAch getOne(Long ach_id);

    @Update("update rec_ach set ach_exam=#{ach_exam},ach_interview=#{ach_interview},ach_status=#{ach_status},ach_comm=#{ach_comm} where ach_id=#{ach_id}")
    public void update(RecAch ach);

    @Delete("delete from rec_ach where ach_id=#{ach_id}")
    public void del(Long ach_id);

}
