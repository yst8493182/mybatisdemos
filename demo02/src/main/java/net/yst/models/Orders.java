package net.yst.models;

import java.util.List;

public class Orders {
    private Integer id;

    private Integer pid;

    private Float total;

    private List<Product> products;

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


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", pid=" + pid +
                ", total=" + total +
                '}';
    }
}