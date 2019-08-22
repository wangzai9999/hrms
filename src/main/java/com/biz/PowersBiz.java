package com.biz;

import com.entity.Powers;

import java.util.List;

public interface PowersBiz {

    public List<Powers> getAllByRole(Long re_id);

    public List<Powers>   getAll();

    public Powers getById(long id);

    public List<Powers> getPaerntById(long id);

    public void add(Powers power);

    public void mod(String name, long id);

    public void del(long id);

    public void modPar(long parentid, long id);

}
