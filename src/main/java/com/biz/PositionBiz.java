package com.biz;

import com.entity.Position;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;

import java.util.List;

public interface PositionBiz {
    public List<Position> getAll();

    public void add(Position p);

    public void del(Long id);

    public  void mod(Position p);

    public Position getOne(Long id);

}
