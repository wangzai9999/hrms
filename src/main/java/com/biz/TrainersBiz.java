package com.biz;

import com.entity.Trainers;
import com.util.PageBean;

import java.util.List;

public interface TrainersBiz {
    public Trainers getOne(Long id);

    public PageBean getAll();

    public void del(Long id);

    public void mod(Trainers trainers);

    public void add(Trainers trainers);

    public List<Trainers> getAllByTRid(Long id);

    public void delBy(Long id);
}
