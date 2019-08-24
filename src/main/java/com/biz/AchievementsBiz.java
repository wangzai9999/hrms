package com.biz;

import com.entity.Achievements;
import com.util.PageBean;

public interface AchievementsBiz {

    public void add(Achievements av);

    public PageBean getAll(int page);

}
