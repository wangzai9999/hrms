package com.biz;

import com.entity.RecAch;
import com.util.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RecAchBiz {

    public RecAch getOne(Long ach_id);

    public void update(RecAch ach);

    public void del(Long ach_id);

    public void add(RecAch ach);

    public PageBean getAllByPage(int page);

    public RecAch getOneByRe(Long resid);

}
