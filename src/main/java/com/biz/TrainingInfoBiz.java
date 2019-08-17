package com.biz;

import com.entity.TrainingInfo;
import com.util.PageBean;
import com.util.TrainingInfoParam;

public interface TrainingInfoBiz {
    public void mod(TrainingInfo trainingInfo);
    public void add(TrainingInfo trainingInfo);
    public void del(Long id);
    public TrainingInfo getOne(Long id);
    public PageBean getAllByPage(int page, TrainingInfoParam param);
}
