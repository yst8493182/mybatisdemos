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


    /**
     *  一对一的查询
     */
    @Test
    public void selectPersonIdNo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Person> persons=sqlSession.selectList("net.yst.dao.PersonMapper.selectPersonIdNo",1);
        System.out.println(persons.size());


        for (Person person : persons) {
            System.out.println(person);
        }

    }


    @Test
    public void selectPersonByIdLazy() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Person person=sqlSession.selectOne("net.yst.dao.PersonMapper.selectPersonByIdLazy", 1);
        List<Orders> ordersList = person.getOrdersList();

        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }


    @Test
    public void selectPersonByPid() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Person person=sqlSession.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);

        /**
         * 每一个session都有独立的缓存空间，所以第二次查询是使用的内存中的数据
         */
        Person person2=sqlSession.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);

        person2.setAge(999);



        sqlSession.update("net.yst.dao.PersonMapper.updateByPrimaryKey", person2);

        sqlSession.commit();
        /**
         * 同一个session中，如果进行更新（update、delete，insert）操作时，内存中的缓存会被清空
         */
        Person person3=sqlSession.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);

        /**
         * 在不同的session中，其他session对数据进行更新操作，这时，之前的session中再去查询，就会获取到脏数据
         */

        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        System.out.println(sqlSession1.equals(sqlSession));


        Person person6=sqlSession1.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);

        person6.setName("脏数据1235778888885655454547");

        sqlSession1.update("net.yst.dao.PersonMapper.updateByPrimaryKey", person6);


        sqlSession1.commit();


//        Person person5=sqlSession1.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);
//
//        System.out.println(person5);

        Person person4=sqlSession.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);

        System.out.println(person4.equals(person3));

        System.out.println(person4);
    }


    /**
     * 启用二级缓存后，不同Session之间的缓存可以共用
     */
    @Test
    public void selectPersonByid() {
        SqlSession sqlSession = null;

        SqlSession sqlSession1 = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            Person person=sqlSession.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();

        }
        try {
            sqlSession1 = sqlSessionFactory.openSession();

            Person person1=sqlSession1.selectOne("net.yst.dao.PersonMapper.selectPersonById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession1.close();

        }





    }




}
