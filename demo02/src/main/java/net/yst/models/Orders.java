package net.yst.models;

import java.io.Serializable;
import java.util.List;

public class Orders implements Serializable {
    private static final long serialVersionUID = 2567646395162008978L;
    private Integer id;

    private Integer pid;

    private Float total;

    private List<Product> products;


    private Person person;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", pid=" + pid +
                ", total=" + total +
                '}';
    }
}