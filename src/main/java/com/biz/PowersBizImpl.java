package com.biz;

import com.dao.PowersDao;
import com.entity.Powers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Powers> getAll() {
        return dao.getAll();
    }

    @Override
    public Powers getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Powers> getPaerntById(long id) {
        return dao.getPaerntById(id);
    }

    @Override
    public void add(Powers power) {
        dao.add(power);
    }

    @Override
    public void mod(String name, long id) {
        dao.mod(name,id);
    }

    @Override
    public void del(long id) {
        Map map=new HashMap();
        map.put("id", id);
        dao.del(map);
    }

    @Override
    public void modPar(long parentid, long id) {
        dao.modPar(parentid,id);
    }
}
