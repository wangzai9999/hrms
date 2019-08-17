package com.biz;

import com.entity.Resume;
import com.util.PageBean;

public interface ResumeBiz {

    public PageBean getAllByPage(int page);

    public void addResume(Resume re);

    public void del(Long id);


}
