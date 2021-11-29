package com.snacktime.order.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


public class Person {
    @Id
    private String userEmail;
    private List<String> orders = new ArrayList<>();

    public Person(String userEmail, String order) {
        this.userEmail = userEmail;
        this.orders.add(order);
    }

    public String getLastOrder(){
        return orders.get(orders.size() - 1);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void addOrder(String order) {
        this.orders.add(order);
    }
}
