package com.dao;

import com.entity.TrainingApplyFo;
import com.util.TrainingApplyFoParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TrainingApplyFoDao {
    @Insert("insert into training_apply_fo values(taf_seq.nextval,#{tf_us_id.us_id},#{tf_tr_id.tr_id},#{tf_status},sysdate,#{tf_auditor},#{tf_opinion})")
    public void add(TrainingApplyFo trainingApplyFo);

    @Update("update training_apply_fo set tf_us_id=#{tf_us_id.us_id},tf_tr_id=#{tf_tr_id.tr_id} where tf_id=#{tf_id}")
    public void mod(TrainingApplyFo trainingApplyFo);

    @Delete("delete from training_apply_fo where tf_id=#{tf_id} ")
    public void del(Long id);

    @Results(value = {
            @Result(column = "tf_us_id",property = "tf_us_id",one = @One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "tf_tr_id",property = "tf_tr_id",one = @One(select = "com.dao.TrainingInfoDao.selectByPrimaryKey",fetchType = FetchType.EAGER))
    },id = "td")
    @Select("select * from training_apply_fo where tf_id=#{tf_id}")
    public TrainingApplyFo getOne(Long id);

    @ResultMap("td")
    @Select("<script>select * from (select t.*,rownum r(select * from training_apply_fo " +
            "<where> <if test='param3.tf_id!=null and param3.tf_id!=0'> and tf_id=#{2.tf_id}</if>" +
            " <if test='param3.tf_status!=null and param3.tf_status!=\"\"'> and tf_status=#{2.tf_status} </if> " +
            "</where> order by tf_id asc)t)a a.r>(#{0}-1)*#{1} and a.r&lt;=#{0}*#{1}</script>")
    public List<TrainingApplyFo> getAllByParam(int page, int pagesize, TrainingApplyFoParam param);

    @Select("<script> select count(1) from training_apply_fo <where>" +
            " <if test='tf_id!=null and tf_id!=0'> and tf_id=#{tf_id}</if>" +
            " <if test='tf_status!=null and tf_status!=\"\"'> and tf_status=#{tf_status} </if> " +
            "</where></script")
    public Long getCoount(TrainingApplyFoParam param);

    @ResultMap("td")
    @Select("select * from training_apply_fo")
    public List<TrainingApplyFo> getAll();

}
