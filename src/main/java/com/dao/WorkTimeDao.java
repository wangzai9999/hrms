package com.dao;

import com.entity.WorkTime;

import java.util.Date;
import java.util.List;

public interface WorkTimeDao {

    public void add(WorkTime wt);

    public void mod(WorkTime wt);

    public List<WorkTime> getAll();

    public WorkTime getWtId(Long usid);

    public Long getTs(Long usid, Date begin,Date end);

    public Long getCd(Long usid, Date begin,Date end);

    public Long getZt(Long usid, Date begin,Date end);



}
