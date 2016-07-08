package net.yst.test;


import net.yst.models.Orders;
import net.yst.models.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by yangshutao on 2016/6/29.
 */
public class PersonTest {
    SqlSessionFactory sqlSessionFactory = null;

    @BeforeMethod
    public void setUp() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis‐config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * collection 嵌套查询
     */
    @Test
    public void selectPersonById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Person> persons=sqlSession.selectList("net.yst.dao.PersonMapper.selectPersonById",1);
        System.out.println(persons.size());
        for (Person person : persons) {
            System.out.println(person);
            List<Orders> ordersList = person.getOrdersList();
            for (Orders orders : ordersList) {
                System.out.println(orders);
            }

        }
    }


    /**
     * 一对多的查询
     */
    @Test
    public void selectPersonOrderProductById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Person> persons=sqlSession.selectList("net.yst.dao.PersonMapper.selectPersonOrderProductById",1);
        System.out.println(persons.size());


        for (Person person : persons) {
            System.out.println(person);
        }

    }


    /**
     * 多对多的查询
     */
    @Test
    public void selectPersonRole(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Person> persons=sqlSession.selectList("net.yst.dao.PersonMapper.selectPersonRole",1);
        System.out.println(persons.size());


        for (Person person : persons) {
            System.out.println(person);
        }

    }


}
