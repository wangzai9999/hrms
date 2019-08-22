package com.biz;

import com.dao.WorkTimeDao;
import com.entity.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Override
    public Long getTs(Long usid) {



        return dao.getTs(usid,this.getBDate(),this.getEDate());
    }

    @Override
    public Long getCd(Long usid) {

        return dao.getCd(usid,this.getBDate(),this.getEDate());
    }

    @Override
    public Long getZt(Long usid) {


        return dao.getZt(usid,this.getBDate(),this.getEDate());
    }

    public Date getBDate(){

        Calendar cab=Calendar.getInstance();
        cab.set(Calendar.DAY_OF_MONTH,1);
        Date begin=cab.getTime();
        return begin;
    }

    public Date getEDate(){
        Calendar cae=Calendar.getInstance();
        cae.set(Calendar.DATE,1);
        cae.roll(Calendar.DATE,-1);
        Date end=cae.getTime();
        return end;
    }

}
