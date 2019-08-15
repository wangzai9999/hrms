package com.biz;

import com.dao.ArchivesDao;
import com.entity.Archives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivesBizImpl implements ArchivesBiz {

    @Autowired
    public ArchivesDao dao;

    public ArchivesDao getDao() {
        return dao;
    }

    public void setDao(ArchivesDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Archives archives) {
        dao.add(archives);
    }

    @Override
    public void del(Long id) {
        dao.del(id);
    }

    @Override
    public void mod(Archives archives) {
        dao.mod(archives);
    }

    @Override
    public Archives getOne(Long id) {
        return dao.getOne(id);
    }

    @Override
    public List<Archives> getAll() {
        return dao.getAll();
    }
}
