package com.dao;

import com.entity.Archives;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface ArchivesDao {

    @ResultMap("ar")
    @Select("select * from archives")
    public List<Archives> getAll();

    @Results(value = {
            @Result(column = "ar_uid",property = "ar_uid",one = @One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER))
    },id = "ar")
    @Select("select * from archives where ar_id=#{id}")
    public Archives getOne(Long id);

    public void add(Archives ar);

    @Delete("delete from archives where ar_uid=@{uid}")
    public void del(Long uid);

    public void mod(Archives ar);

}
