package net.yst.test;

import net.yst.models.IdNo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by yangshutao on 2016/7/13.
 */
public class IdNoTest {

    SqlSessionFactory sqlSessionFactory = null;

    @BeforeMethod
    public void setUp() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis‐config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectIdNoPerson(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<IdNo> idNos=sqlSession.selectList("net.yst.dao.IdNoMapper.selectIdNoPerson",1);
        System.out.println(idNos.size());


        for (IdNo idNo : idNos) {
            System.out.println(idNo);
        }



    }
}
