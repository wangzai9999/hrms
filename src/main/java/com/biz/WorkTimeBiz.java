package com.biz;

import com.entity.WorkTime;

import java.util.List;

public interface WorkTimeBiz {
    public void add(WorkTime wt);

    public void mod(WorkTime wt);

    public List<WorkTime> getAll();

    public WorkTime getWtId(Long usid);

}
