package com.dao;

import com.entity.Archives;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArchivesDao extends Mapper<Archives>{

    @ResultMap("ar")
    @Select("select * from archives")
    public List<Archives> getAll();

    @Results(value = {
            @Result(column = "ar_uid",property = "ar_uid",one = @One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    },id = "ar")
    @Select("select * from archives where ar_id=#{id}")
    public Archives getOne(Long id);
}
