package net.yst.test;

import net.yst.dao.PersonMapper;
import net.yst.models.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
/**
 * Created by yangshutao on 2016/7/20.
 */
public class TestSpring {


    @Resource
    private PersonMapper personMapper = null;

    @Test
    public void testQuery(){


        Person person=personMapper.selectByPrimaryKey(1);
        System.out.println(person);
    }
}
