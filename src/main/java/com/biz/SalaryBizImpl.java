package com.biz;

import com.dao.SalaryDao;
import com.entity.Salary;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryBizImpl implements SalaryBiz{

    @Autowired
    private SalaryDao dao;

    public SalaryDao getDao() {
        return dao;
    }

    public void setDao(SalaryDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Salary sl) {
        dao.add(sl);
    }

    @Override
    public PageBean getAllByPage(int page) {
        PageBean pb = new PageBean();
        pb.setCurrpage(page);
        pb.setList(dao.getAll(page,5));
        pb.setTotalNum(dao.getCount().intValue());
        return pb;
    }
}
