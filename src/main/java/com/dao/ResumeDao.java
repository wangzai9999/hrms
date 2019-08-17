package com.dao;

import com.entity.Resume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResumeDao {

    @Select("slect * from (select r.*,rownum from resume r) x where x.r>(#{0}-1)*#{1} and x.r<=#{0}*#{1}")
    public List<Resume> getAll(int page,int pagesize);

    @Select("select count(1) from resume")
    public Long getCount();

    @Insert("insert into resume values(re_seq.nextval,#{re_name},#{re_position},#{re_enid.en_id},#{re_time},#{re_url})")
    public void add(Resume re);

    @Delete("delete from resume where re_id=#{id}")
    public void del(Long id);



}
