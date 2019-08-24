package com.biz;

import com.dao.AchievementsDao;
import com.entity.Achievements;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementsBizImpl implements AchievementsBiz{

    @Autowired
    private AchievementsDao dao;

    public AchievementsDao getDao() {
        return dao;
    }

    public void setDao(AchievementsDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Achievements av) {
        dao.add(av);
    }

    @Override
    public PageBean getAll(int page) {
        PageBean pb = new PageBean();
        pb.setList(dao.getAll(page,5));
        pb.setCurrpage(page);
        pb.setTotalNum(dao.getCount().intValue());
        return pb;
    }
}
