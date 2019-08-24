package com.biz;

import com.entity.Salary;
import com.util.PageBean;

public interface SalaryBiz {

    public void add(Salary sl);

    public PageBean getAllByPage(int page);

}
