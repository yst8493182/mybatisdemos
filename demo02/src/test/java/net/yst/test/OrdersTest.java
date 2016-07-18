package net.yst.test;

import net.yst.models.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by yangshutao on 2016/7/12.
 */
public class OrdersTest {

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
     * 多对一查询
     */
    @Test
    public void testSelectOrderPerson() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Orders> list = sqlSession.selectList("net.yst.dao.OrdersMapper.selectOrderPerson",1);
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }


    /**
     * 多对一、一对多混合查询
     */
    @Test
    public void testSelectOrderPersonProduct() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Orders> list = sqlSession.selectList("net.yst.dao.OrdersMapper.selectOrderPersonProduct",1);
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }

}
