package com.dao;

import com.entity.Powers;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PowersDao {

    @Select("select * from powers where po_id in (select p_id from role_power where r_id=#{re_id})")
    public List<Powers> getAllByRole(Long re_id);

}
