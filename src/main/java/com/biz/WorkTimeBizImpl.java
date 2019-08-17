package com.biz;

import com.dao.WorkTimeDao;
import com.entity.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeBizImpl implements WorkTimeBiz {
    @Autowired
    private WorkTimeDao dao;

    public WorkTimeDao getDao() {
        return dao;
    }

    public void setDao(WorkTimeDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(WorkTime wt) {
        dao.add(wt);
    }

    @Override
    public void mod(WorkTime wt) {
       dao.mod(wt);
    }

    @Override
    public List<WorkTime> getAll() {
        return null;
    }

    @Override
    public WorkTime getWtId(Long usid) {
        return dao.getWtId(usid);
    }
}
