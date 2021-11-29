package com.snacktime.order.controllers;



import com.snacktime.order.exceptions.orderNotFoundException;
import com.snacktime.order.models.Order;
import com.snacktime.order.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    String createOrder(@RequestBody Order order){
        orderRepository.save(order);
        return order.getId();
    }

    @GetMapping("/orders")
    List<Order> listOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    Order getOrder(@PathVariable String id){
        return orderRepository.findById(id).orElseThrow(
                () -> new orderNotFoundException("Orden no encontrada con la id: " + id)
        );
    }

   /* @GetMapping("/orderMachine/{idMachine}")
    List<Order> listOrdersByMachine(@PathVariable Integer idMachine){
        return orderRepository.filterByIdMachine(idMachine);
    }*/
}
