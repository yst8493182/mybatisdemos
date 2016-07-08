package net.yst.test;


import net.yst.models.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by yangshutao on 2016/6/29.
 */
public class RoleTest {
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
     * 多对多
     */
    @Test
    public void selectPersonRole(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Role> roles=sqlSession.selectList("net.yst.dao.RoleMapper.selectRolePerson",2);
        System.out.println(roles.size());

        for (Role role : roles) {
            System.out.println(role);
        }

    }


}
