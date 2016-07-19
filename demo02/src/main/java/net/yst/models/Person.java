package net.yst.models;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Person  implements Serializable{


    private static final long serialVersionUID = 4404882079370537607L;
    private Integer pid;

    private String name;

    private Integer age;

    private Date birthday;

    private List<Orders> ordersList;

    private List<Role> roleList;

    private IdNo idNo;

    public IdNo getIdNo() {
        return idNo;
    }

    public void setIdNo(IdNo idNo) {
        this.idNo = idNo;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", ordersList=" + ordersList +
                '}';
    }
}