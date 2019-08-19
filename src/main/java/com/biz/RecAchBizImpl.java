package com.biz;

import com.dao.RecAchDao;
import com.entity.RecAch;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecAchBizImpl implements RecAchBiz{

    @Autowired
    private RecAchDao dao;

    public RecAchDao getDao() {
        return dao;
    }

    public void setDao(RecAchDao dao) {
        this.dao = dao;
    }

    @Override
    public RecAch getOne(Long ach_id) {
        return dao.getOne(ach_id);
    }

    @Override
    public void update(RecAch ach) {
        dao.update(ach);
    }

    @Override
    public void del(Long ach_id) {
        dao.del(ach_id);
    }

    @Override
    public void add(RecAch ach) {
        dao.add(ach);
    }

    @Override
    public PageBean getAllByPage(int page) {
        PageBean pb = new PageBean();
        pb.setCurrpage(page);
        pb.setTotalNum(dao.getCount().intValue());
        pb.setList(dao.getAllByPage(page,5));
        return pb;
    }
}
