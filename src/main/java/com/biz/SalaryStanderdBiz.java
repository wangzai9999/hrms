package com.biz;

import com.entity.SalaryStanderd;
import com.util.PageBean;

public interface SalaryStanderdBiz {

    public void add(SalaryStanderd salst);

    public void del(Long id);

    public SalaryStanderd getOne(Long id);

    public void mod(SalaryStanderd salst);

    public PageBean getAll(int page);
}
