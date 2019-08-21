package com.dao;

import com.entity.WorkTime;

import java.util.List;

public interface WorkTimeDao {

    public void add(WorkTime wt);

    public void mod(WorkTime wt);

    public List<WorkTime> getAll();

    public List<WorkTime> getWtId(Long usid);


}
