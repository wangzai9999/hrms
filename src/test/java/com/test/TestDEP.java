package com.test;

import com.dao.DepartmentDao;
import com.entity.Department;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDEP {

    @Test
    public  void ttt(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentDao dao=context.getBean(DepartmentDao.class);
        Department d=new Department();
        d.setDe_name("人事部");
        dao.add(d);
    }
}
