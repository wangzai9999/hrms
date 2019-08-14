package com.biz;

import com.dao.PowersDao;
import com.entity.Powers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowersBizImpl implements  PowersBiz{

    @Autowired
    private PowersDao dao;

    public PowersDao getDao() {
        return dao;
    }

    public void setDao(PowersDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Powers> getAllByRole(Long re_id) {
        return dao.getAllByRole(re_id);
    }
}
