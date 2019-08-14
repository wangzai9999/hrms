package com.biz;

import com.dao.SalaryStanderdDao;
import com.entity.SalaryStanderd;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryStanderdBizImpl implements SalaryStanderdBiz {

    @Autowired
    private SalaryStanderdDao dao;

    public SalaryStanderdDao getDao() {
        return dao;
    }

    public void setDao(SalaryStanderdDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(SalaryStanderd salst) {
         dao.add(salst);
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }

    @Override
    public SalaryStanderd getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public SalaryStanderd mod(SalaryStanderd salst) {
        return dao.mod(salst);
    }

    @Override
    public PageBean getAll(int page) {
        PageBean pb=new PageBean();
        pb.setCurrpage(page);
        pb.setTotalNum(dao.totalNum().intValue());
        pb.setList(dao.getAll(page, pb.getPageSize()));
        return pb;
    }
}
