package com.snacktime.order.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;


public class Order {
    @Id
    private String id;
    private List<String> products;
    private Date dateCreate;
    private Integer balanceOrder;
    private Integer idMachine;

    public Order(String id, List<String> products, Date dateCreate, Integer idMachine) {
        this.id = id;
        this.products = products;
        this.dateCreate = new Date();
        this.idMachine = idMachine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getBalanceOrder() {
        return balanceOrder;
    }

    public void setBalanceOrder(Integer balanceOrder) {
        this.balanceOrder = balanceOrder;
    }

    public Integer getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Integer idMachine) {
        this.idMachine = idMachine;
    }
}
