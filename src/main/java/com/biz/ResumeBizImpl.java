package com.biz;

import com.dao.ResumeDao;
import com.entity.Resume;
import com.entity.Userinfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageBean getAllByPage(int page,Long enid) {
        PageBean pb = new PageBean();
        pb.setCurrpage(page);
        pb.setList(dao.getAll(page,5,enid));
        pb.setTotalNum(dao.getCount(enid).intValue());
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

    @Override
    public Resume getOne(Long re_id) {
        return dao.getOne(re_id);
    }

    @Override
    public Userinfo getUserinfoByReid(Long reid) {
        return dao.getUserinfoByReid(reid);
    }

}
