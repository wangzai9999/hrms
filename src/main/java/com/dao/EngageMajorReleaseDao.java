package com.dao;

import com.entity.EngageMajorRelease;
import com.util.EngageParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface EngageMajorReleaseDao {

    @ResultMap("en")
    public List<EngageMajorRelease> getAll(@Param("page") int page, @Param("pagesize") int pagesize, @Param("enp")EngageParam enp);

    public Long getCount(@Param("enp") EngageParam enp);

    @Delete("begin " +
            " delete from resume where re_enid=#{en_id}" +
            "delete from engage_major_release where en_id=#{en_id};" +
            "end;")
    public void del(Long en_id);

    @Results(value = {
            @Result(column = "en_dep",property = "en_dep",one = @One(select = "com.dao.DepartmentDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "en_pos",property = "en_pos",one = @One(select = "com.dao.PositionDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "en_creater",property = "en_creater",one = @One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    },id="en")
    @Select("select * from engage_major_release where en_id=#{en_id}")
    public EngageMajorRelease getOne(Long en_id);

    @Insert("insert into engage_major_release values(en_seq.nextval,#{en_dep.de_id},#{en_pos.pos_id},#{en_account},#{en_deadline},#{en_major_describe},#{en_experience},#{en_creater.us_id},#{en_createtime},#{en_status})")
    public void add(EngageMajorRelease en);

    @Update("update engage_major_release set en_dep=#{en_dep.de_id},en_pos=#{en_pos.pos_id},en_account=#{en_account},en_deadline=#{en_deadline},en_major_describe=#{en_major_describe},en_experience=#{en_experience},en_creater=#{en_creater.us_id},en_createtime=#{en_createtime},en_status=#{en_status} where en_id=#{en_id}")
    public void update(EngageMajorRelease en);

}
