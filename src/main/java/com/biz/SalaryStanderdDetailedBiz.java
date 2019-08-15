package com.biz;

import com.entity.SalaryStanderdDetailed;

import java.util.List;

public interface SalaryStanderdDetailedBiz {

    public void add(SalaryStanderdDetailed ssd, Long stid);

    public void del(Long ssdid,Long stid);

    public SalaryStanderdDetailed getOne(Long ssdid);

    public List<SalaryStanderdDetailed> getAllById(Long sid);

}
