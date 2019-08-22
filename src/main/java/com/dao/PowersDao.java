package com.dao;

import com.entity.Powers;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface PowersDao {

    @ResultMap("po")
    @Select("select * from powers where po_id in (select p_id from role_power where r_id=#{re_id})")
    public List<Powers> getAllByRole(Long re_id);


    @Results(value={
            @Result(column="po_name",property="text"),
            @Result(column="po_id",property="id"),
            @Result(column="po_fa",property="po_fa",one=@One(select="getById",fetchType=FetchType.EAGER)),
            @Result(column="po_id",property="children",many=@Many(select="getPaerntById",fetchType= FetchType.EAGER))
    },id="po")
    @Select("select * from powers where po_fa is null")
    public List<Powers>   getAll();

    @Select("select * from powers where po_id=#{id}")
    public Powers getById(long id);


    @ResultMap("po")
    @Select("select * from powers where po_fa=#{id}")
    public List<Powers> getPaerntById(long id);

    @Insert("insert into powers values(po_seq.nextval,#{text},#{po_url},#{po_fa.id})")
    public void add(Powers power);

    @Update("update powers set po_name=#{0} where po_id=#{1}")
    public void mod(String name ,long id);


    @Update("update powers set po_fa=#{0} where po_id=#{1}")
    public void modPar(long po_fa ,long id);

    @Delete("{call power_pro(#{id,mode=IN,jdbcType=DOUBLE})}")
    public void del(Map map);

}
