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
    public void selectById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        List<Person> personList=sqlSession.selectList("mappers.PersonMapper.selectById", map);
    }

    @Test
    public void testAddPerson() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Person person = new Person();
        person.setPname("魅族");
        person.setAge(3);
        person.setAddress("盐城大丰");
        person.setBirthday(new Date());
        int count=sqlSession.insert("mappers.PersonMapper.addPerson", person);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(person);
    }

}
