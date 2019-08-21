package com.biz;

import com.dao.TrainersDao;
import com.dao.TrainingApplyFoDao;
import com.entity.Trainers;
import com.entity.TrainingApplyFo;
import com.util.PageBean;
import com.util.TrainingApplyFoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingApplyFoBizImpl implements TrainingApplyFoBiz {

    @Autowired
    private TrainingApplyFoDao dao;
    @Autowired
    private TrainersDao to;

    public TrainingApplyFoDao getDao() {
        return dao;
    }

    public void setDao(TrainingApplyFoDao dao) {
        this.dao = dao;
    }

    public TrainersDao getTo() {
        return to;
    }

    public void setTo(TrainersDao to) {
        this.to = to;
    }

    @Override

    public void add(TrainingApplyFo trainingApplyFo) {
        dao.add(trainingApplyFo);
    }

    @Override
    public void mod(TrainingApplyFo trainingApplyFo) {
        dao.mod(trainingApplyFo);
        if (trainingApplyFo.getTf_status().equals("同意")){
            TrainingApplyFo fo= dao.getOne(trainingApplyFo.getTf_id());
            Trainers trainers=new Trainers();
            trainers.setTs_usid(fo.getTf_us_id());
            trainers.setTs_trid(fo.getTf_tr_id());
            to.add(trainers);
        }
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }

    @Override
    public TrainingApplyFo getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public List<TrainingApplyFo> getAll() {
        return dao.getAll();
    }

    @Override
    public PageBean getAllByParam(int page, TrainingApplyFoParam param) {
        PageBean pageBean=new PageBean();
        pageBean.setTotalNum(dao.getCoount(param).intValue());
        if (page>pageBean.getTotalPage()) page=pageBean.getTotalPage();
        pageBean.setCurrpage(page);
        pageBean.setList(dao.getAllByParam(page,pageBean.getPageSize(),param));
        return pageBean;
    }

    @Override
    public TrainingApplyFo getByTfUs(Long id) {
        return dao.getByTfUs(id);
    }


}
