package com.biz;

import com.entity.Resume;
import com.util.PageBean;

import java.util.List;

public interface ResumeBiz {

    public PageBean getAllByPage(int page,Long enid);

    public void addResume(Resume re);

    public void del(Long id);

    public Resume getOne(Long re_id);

}
