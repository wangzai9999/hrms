package com.biz;

import com.dao.SalaryStanderdDetailedDao;
import com.entity.SalaryStanderdDetailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryStanderdDetailedBizImpl implements SalaryStanderdDetailedBiz {
    @Autowired
    private SalaryStanderdDetailedDao dao;

    public SalaryStanderdDetailedDao getDao() {
        return dao;
    }

    public void setDao(SalaryStanderdDetailedDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(SalaryStanderdDetailed ssd, Long stid) {
         dao.add(ssd, stid);
    }

    @Override
    public void del(Long ssdid,Long stid) {
        SalaryStanderdDetailed ssd=this.getOne(ssdid);
        dao.del(ssd, stid);
    }

    @Override
    public SalaryStanderdDetailed getOne(Long ssdid) {
        return dao.getOne(ssdid);
    }

    @Override
    public List<SalaryStanderdDetailed> getAllById(Long sid) {
        return dao.getAllById(sid);
    }
}
