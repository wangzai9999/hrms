package com.dao;

import com.entity.Trainers;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TrainersDao {

    @Insert("insert into trainers values (ts_seq.nextval,#{ts_trid.tr_id},#{ts_comm},#{ts_usid.us_id}),#{starNum}")
    public void add(Trainers trainers);

    @Update("update trainers set ts_comm=#{ts_comm},starNum=#{starNum} where ts_id=#{ts_id}")
    public void mod(Trainers trainers);

    @Delete("delete from trainers where ts_id=#{id}")
    public void del(Long id);
    @Delete("delete from trainers where ts_trid=#{id}")
    public void delBy(Long id);

    @Results(value = {
            @Result(column ="ts_usid",property = "ts_usid",one = @One(select = "com.dao.UserinfoDao.getOne",fetchType = FetchType.EAGER)),
            @Result(column = "ts_trid",property = "ts_trid",one = @One(select = "com.dao.TrainingInfoDao.getOne",fetchType = FetchType.EAGER))
    },id = "ts")
    @Select("select * from trainers where ts_id=#{id}")
    public Trainers getOne(Long id);

    @ResultMap("ts")
    @Select("select * from trainers")
    public List<Trainers> getAll();

    @Select("select count(1) from trainers")
    public Long getCount();

    @ResultMap("ts")
    @Select("select * from trainers where ts_trid=#{id}")
    public List<Trainers> getAllByTRid(Long id);

    @Select("select count(1) from trainers where ts_trid=#{id}")
    public Long getCountByTrid(Long id);

}
