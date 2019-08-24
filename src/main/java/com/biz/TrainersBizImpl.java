package com.biz;

import com.dao.TrainersDao;
import com.dao.TrainingInfoDao;
import com.entity.Trainers;
import com.entity.TrainingInfo;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainersBizImpl implements TrainersBiz {

    @Autowired
    private TrainersDao dao;

    @Autowired
    private TrainingInfoDao to;

    public TrainersDao getDao() {
        return dao;
    }

    public void setDao(TrainersDao dao) {
        this.dao = dao;
    }

    public TrainingInfoDao getTo() {
        return to;
    }

    public void setTo(TrainingInfoDao to) {
        this.to = to;
    }

    @Override
    public Trainers getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public PageBean getAll() {
        PageBean pageBean=new PageBean();
        pageBean.setDiv(to.selectAll());
        pageBean.setList(dao.getAll());
        return pageBean;
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }

    @Override
    public void mod(Trainers trainers) {
        dao.mod(trainers);
    }

    @Override
    public void add(Trainers trainers) {
        dao.add(trainers);
    }

    @Override
    public List<Trainers> getAllByTRid(Long id) {
        return dao.getAllByTRid(id);
    }

    @Override
    public void delBy(Long id) {
        dao.delBy(id);
    }
}
