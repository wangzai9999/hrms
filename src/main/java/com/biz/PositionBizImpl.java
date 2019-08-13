package com.biz;

import com.dao.PositionDao;
import com.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionBizImpl implements PositionBiz {
    @Autowired
    private PositionDao dao;

    public PositionDao getDao() {
        return dao;
    }

    public void setDao(PositionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Position> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(Position p) {
        dao.add(p);
    }

    @Override
    public void del(Long id) {

        dao.del(id);
    }

    @Override
    public void mod(Position p) {

        dao.mod(p);
    }

    @Override
    public Position getOne(Long id) {
        return dao.getOne(id);
    }
}
