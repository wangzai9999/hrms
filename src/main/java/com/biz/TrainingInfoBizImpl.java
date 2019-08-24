package com.biz;

import com.dao.TrainersDao;
import com.dao.TrainingApplyFoDao;
import com.dao.TrainingInfoDao;
import com.entity.Trainers;
import com.entity.TrainingApplyFo;
import com.entity.TrainingInfo;
import com.util.PageBean;
import com.util.TrainingInfoParam;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingInfoBizImpl implements TrainingInfoBiz{

    @Autowired
    private TrainingInfoDao dao;

    public TrainingInfoDao getDao() {
        return dao;
    }

    @Autowired
    private TrainingApplyFoDao td;

    public TrainingApplyFoDao getTd() {
        return td;
    }

    public void setTd(TrainingApplyFoDao td) {
        this.td = td;
    }

    public void setDao(TrainingInfoDao dao) {
        this.dao = dao;
    }

    @Override
    public void mod(TrainingInfo trainingInfo) {
        dao.updateByPrimaryKeySelective(trainingInfo);
    }

    @Override
    public void add(TrainingInfo trainingInfo) {
        dao.add(trainingInfo);
    }

    @Override
    public void del(Long id) {
        dao.deleteByPrimaryKey(id);
    }

    @Override
    public TrainingInfo getOne(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public PageBean getAllByPage(int page, TrainingInfoParam param) {
        PageBean pageBean=new PageBean();
        pageBean.setTotalNum(dao.getCount(param).intValue());
        if (page>pageBean.getTotalPage()) page=pageBean.getTotalPage();
        pageBean.setCurrpage(page);
        pageBean.setList(dao.getAllByParam(page,pageBean.getPageSize(),param));

        pageBean.setDiv(td.getAll());
        return pageBean;
    }

    @Override
    public List<TrainingInfo> getAll() {
        return dao.selectAll();
    }


}
