package com.dao;

import com.entity.SalaryStanderdDetailed;

import java.util.List;

public interface SalaryStanderdDetailedDao {

    public List<SalaryStanderdDetailed> getAllById(Long sid);

    public void add(SalaryStanderdDetailed ssd,Long stid);

    public void del(SalaryStanderdDetailed ssd,Long stid);

    public SalaryStanderdDetailed getOne(Long ssdid);



}
