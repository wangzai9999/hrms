package com.biz;

import com.entity.Archives;

import java.util.List;

public interface ArchivesBiz {
    public void add(Archives archives);

    public void del(Long id);
    public void mod(Archives archives);
    public Archives getOne(Long id);

    public List<Archives> getAll();
}
