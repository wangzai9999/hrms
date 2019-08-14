package com.biz;

import com.entity.EngageMajorRelease;
import com.util.PageBean;

public interface EngageMajorReleaseBiz {

    public PageBean getAllByPage(int page);

    public EngageMajorRelease getOne(Long en_id);

    public void add(EngageMajorRelease en);

    public void del(Long en_id);

    public void update(EngageMajorRelease en);


}
