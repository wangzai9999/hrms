package com.dao;

import com.entity.Achievements;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AchievementsDao {

    @Insert("insert into achievements values(av_seq.nextval,#{us_id.us_id},#{av_man.us_id},#{av_day_score},#{av_man_score},sysdate,#{av_sr})")
    public void add(Achievements av);

    @Results(
            {@Result(property = "us_id",column = "us_id",one=@One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER)),
            @Result(property = "av_man",column = "av_man",one=@One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))}
    )
    @Select("select * from (select av.*,rownum r from achievements av) x where x.r>(#{0}-1)*#{1} and x.r<=#{0}*#{1}")
    public List<Achievements> getAll(int page, int pagesize);

    @Select("select count(1) from achievements")
    public Long getCount();

}
