package com.biz;

import com.dao.EngageMajorReleaseDao;
import com.entity.EngageMajorRelease;
import com.util.EngageParam;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngageMajorReleaseBizImpl implements EngageMajorReleaseBiz{

    @Autowired
    private EngageMajorReleaseDao dao;

    public EngageMajorReleaseDao getDao() {
        return dao;
    }

    public void setDao(EngageMajorReleaseDao dao) {
        this.dao = dao;
    }

    @Override
    public PageBean getAllByPage(int page, EngageParam enp) {
        PageBean pb = new PageBean();
        pb.setCurrpage(page);
        pb.setTotalNum(dao.getCount(enp).intValue());
        pb.setList(dao.getAll(page,5,enp));
        return pb;
    }

    @Override
    public EngageMajorRelease getOne(Long en_id) {
        return dao.getOne(en_id);
    }

    @Override
    public void add(EngageMajorRelease en) {
        dao.add(en);
    }

    @Override
    public void del(Long en_id) {
        dao.del(en_id);
    }

    @Override
    public void update(EngageMajorRelease en) {
        dao.update(en);
    }
}
