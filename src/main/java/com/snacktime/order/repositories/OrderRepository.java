package com.snacktime.order.repositories;

import com.snacktime.order.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    //List<Order> filterByIdMachine (Integer idMachine);
}
