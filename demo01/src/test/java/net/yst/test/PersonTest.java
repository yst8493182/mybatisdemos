package net.yst.test;

import net.yst.models.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

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


    @Test
    public void selectById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        List<Person> personList = sqlSession.selectList("mappers.PersonMapper.selectById", map);
    }

    @Test
    public void testAddPerson() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Person person = new Person();
        person.setPname("魅族");
        person.setAge(3);
        person.setAddress("盐城大丰");
        person.setBirthday(new Date());
        int count = sqlSession.insert("mappers.PersonMapper.addPerson", person);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(person);
    }


    /**
     * 动态sql 查询
     */
    @Test
    public void dynamicSelect() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("age", 5);
        List<Person> persons = sqlSession.selectList("mappers.PersonMapper.dynamicSelect", map);
        sqlSession.close();
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    /**
     * 动态sql 查询
     */
    @Test
    public void dynamicSelect1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person person = new Person();
        person.setPid(6);
        person.setAge(5);
        List<Person> persons = sqlSession.selectList("mappers.PersonMapper.dynamicSelect1", person);
        sqlSession.close();
        for (Person p : persons) {
            System.out.println(p);
        }
    }


    /**
     * 动态sql 插入数据
     */
    @Test
    public void dynamicInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String, List<Person>> map = new HashMap<>();
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        map.put("persons", personList);
        for(int i = 0; i < 200; i++) {
            person.setPname("测试"+i);
            person.setAge(i);
            personList.add(person);
            if (i % 20 == 0) {
                sqlSession.insert("mappers.PersonMapper.dynamicInsert", map);
                personList.clear();
            }
        }
        sqlSession.insert("mappers.PersonMapper.dynamicInsert", map);


        sqlSession.commit();
        sqlSession.close();

    }

}
