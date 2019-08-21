package com.dao;

import com.entity.Achievements;

import java.util.List;

public interface AchievementsDao {

    public void add(Achievements ac);

    public List<Achievements> getAll();

    public Achievements getOne();
}
