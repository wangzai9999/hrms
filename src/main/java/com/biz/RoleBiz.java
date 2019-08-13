package com.biz;

import com.entity.Role;

import java.util.List;

public interface RoleBiz {

    public List<Role> getAllRole();

    public Role getOne(Long id);

    public void add(Role r);

    public void del(Long id);

}
