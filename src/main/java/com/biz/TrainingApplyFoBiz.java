package com.biz;

import com.entity.TrainingApplyFo;
import com.util.PageBean;
import com.util.TrainingApplyFoParam;

import java.util.List;

public interface TrainingApplyFoBiz {

    public void add(TrainingApplyFo trainingApplyFo);

    public void mod(TrainingApplyFo trainingApplyFo);

    public void del(Long id);

    public TrainingApplyFo getOne(Long id);
    public List<TrainingApplyFo> getAll();
    public PageBean getAllByParam(int page, TrainingApplyFoParam param);

    public TrainingApplyFo getByTfUs(Long id);
}
