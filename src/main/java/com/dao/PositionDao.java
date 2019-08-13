package com.dao;

import com.entity.Position;

import java.util.List;

public interface PositionDao {
    public List<Position> getAll();

    public void add(Position p);

    public void del(Long id);

    public  void mod(Position p);

    public Position getOne(Long id);

}
