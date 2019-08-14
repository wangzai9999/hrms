package com.dao;

import com.entity.SalaryStanderd;

import java.util.List;

public interface SalaryStanderdDao {

    public void add(SalaryStanderd salst);

    public void del(Long id);

    public SalaryStanderd getOne(Long id);

    public SalaryStanderd mod(SalaryStanderd salst);

    public List<SalaryStanderd> getAll(int page,int rows);

    public Long totalNum();

}
