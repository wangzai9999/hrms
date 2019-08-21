package com.test;

import com.dao.DepartmentDao;
import com.dao.UserinfoDao;
import com.entity.Department;
import com.entity.Userinfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDEP {


    public  void ttt(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentDao dao=context.getBean(DepartmentDao.class);
        Department d=new Department();
        d.setDe_name("人事部");
        dao.add(d);
    }

    @Test
    public  void ttt11(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserinfoDao dao=context.getBean(UserinfoDao.class);

    }
}
