package com.biz;

import com.entity.Position;

import java.util.List;

public interface PositionBiz {
    public List<Position> list();

    public void add(Position p);

    public void del(Long id);

    public  void mod(Position p);

    public Position getOne(Long id);

}
