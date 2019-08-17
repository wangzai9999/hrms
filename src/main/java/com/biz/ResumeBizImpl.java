package com.biz;

import com.dao.ResumeDao;
import com.entity.Resume;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeBizImpl implements ResumeBiz{

    @Autowired
    private ResumeDao dao;

    public ResumeDao getDao() {
        return dao;
    }

    public void setDao(ResumeDao dao) {
        this.dao = dao;
    }


    @Override
    public PageBean getAllByPage(int page) {
        PageBean pb = new PageBean();
        pb.setCurrpage(page);
        pb.setList(dao.getAll(page,5));
        pb.setTotalNum(dao.getCount().intValue());
        return pb;
    }

    @Override
    public void addResume(Resume re) {
        dao.add(re);
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }
}
