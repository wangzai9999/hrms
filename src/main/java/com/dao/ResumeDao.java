package com.dao;

import com.entity.Resume;
import com.entity.Userinfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.ui.Model;

import java.util.List;

public interface ResumeDao {

    @ResultMap("re")
    public List<Resume> getAll(@Param("page") int page,@Param("pagesize")int pagesize,@Param("enid")Long enid);

    public Long getCount(@Param("enid")Long enid);

    @Insert("insert into resume values(re_seq.nextval,#{re_name},#{re_position},#{re_enid.en_id},#{re_url},#{re_time},#{re_status})")
    public void add(Resume re);

    @Delete("begin " +
            " delete from rec_ach where ach_resid=#{re_id};" +
            "delete from resume where re_id=#{re_id};" +
            "end;")
    public void del(Long re_id);

    @Results(value={
            @Result(property = "re_enid",column = "re_enid",one = @One(select = "com.dao.EngageMajorReleaseDao.getOne",fetchType = FetchType.EAGER))
    },id="re")
    @Select("select * from resume where re_id=#{re_id}")
    public Resume getOne(Long re_id);

    @Select("select u.* from resume r,engage_major_release e,department d,userinfo u where r.re_enid=e.en_id and e.en_dep=d.de_id and d.de_man=u.us_id and r.re_id=#{reid}")
    public Userinfo getUserinfoByReid(Long reid);

}
