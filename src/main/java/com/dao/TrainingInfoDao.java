package com.dao;

import com.entity.TrainingInfo;
import com.util.TrainingInfoParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TrainingInfoDao extends Mapper<TrainingInfo> {

    @Insert("insert into training_info values(tr_seq.nextval,#{tr_man},#{tr_subject},#{tr_status},#{tr_starttime},#{tr_endtime},#{tr_remark},#{tr_num})")
    public void add(TrainingInfo trainingInfo);

    @Select("<script> select * from (select t.*,rownum r from (select * from training_info " +
            "<where> <if test='param3.tr_subject!=null and param3.tr_subject!=\"\"'> and tr_subject like '%'||#{2.tr_subject}||'%'</if>" +
            "  <if test='param3.tr_status!=null and param3.tr_status!=\"\"'>  and tr_status=#{2.tr_status} </if>" +
            " <if test='param3.minstarttime!=null' > and tr_starttime >=#{2.minstarttime}</if>" +
            " <if test='param3.maxstarttime!=null' > and tr_starttime &lt;=#{2.maxstarttime} </if> " +
            " </where> order by tr_id asc)t)a where a.r>(#{0}-1)*#{1} and a.r<![CDATA[<=]]>#{0}*#{1} </script>")
    public List<TrainingInfo> getAllByParam(int page, int pagesize, TrainingInfoParam param);

    @Select("<script> select count(1) from training_info " +
            "<where> <if test='tr_subject!=null and tr_subject!=\"\"'> and tr_subject like '%'||#{tr_subject}||'%'</if>" +
            "  <if test='tr_status!=null and tr_status!=\"\"'>  and tr_status=#{tr_status} </if>" +
            " <if test='minstarttime!=null' > and tr_starttime >=#{minstarttime}</if>" +
            " <if test='maxstarttime!=null' > and tr_starttime &lt;=#{maxstarttime} </if> " +
            "</where> </script>")
    public Long getCount(TrainingInfoParam param);
}
