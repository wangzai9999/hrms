package com.dao;

import com.entity.Resume;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ResumeDao {

    @Results({
            @Result(property = "re_enid",column = "re_enid",one = @One(select = "com.dao.EngageMajorReleaseDao.getOne",fetchType = FetchType.EAGER))
    })
    @Select("select * from (select re.*,rownum r from resume re) x where x.r>(#{0}-1)*#{1} and x.r<=#{0}*#{1}")
    public List<Resume> getAll(int page,int pagesize);

    @Select("select count(1) from resume")
    public Long getCount();

    @Insert("insert into resume values(re_seq.nextval,#{re_name},#{re_position},#{re_enid.en_id},#{re_url},#{re_time})")
    public void add(Resume re);

    @Delete("delete from resume where re_id=#{re_id}")
    public void del(Long re_id);



}
