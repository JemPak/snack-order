package com.snacktime.order.controllers;

import com.snacktime.order.exceptions.machineNotFoundException;
import com.snacktime.order.exceptions.orderNotFoundException;
import com.snacktime.order.exceptions.personNotFoundException;
import com.snacktime.order.models.Order;
import com.snacktime.order.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    String inicio(){
        return "Order Microservice By Juan Jose Monsalve 2021/11/30";
    }

    @PostMapping("/orders")
    String createOrder(@RequestBody Order order){
        orderRepository.save(order);
        return "Creación de orden exitosa!";
    }

    @GetMapping("/orders")
    List<Order> listOrders(){
        return orderRepository.findAll();
    }


    @GetMapping("/order/{id}")
    Order getOrder(@PathVariable String id){
        return orderRepository.findById(id).orElseThrow(
                () -> new orderNotFoundException("Orden no encontrada con la ID: " + id)
        );
    }

   @GetMapping("/ordersMachine/{idMachine}")
    List<Order> listOrdersByMachine(@PathVariable Integer idMachine){
        if (!orderRepository.findByIdMachine(idMachine).isEmpty()){
            return orderRepository.findByIdMachine(idMachine);
        }
        throw new machineNotFoundException("No se encontró la máquina con la ID: " + idMachine);
    }

    @PutMapping("/orders")
    String updateOrder(@RequestBody Order order){
        orderRepository.save(order);
        return "Actualización Exitosa";
    }

    @DeleteMapping("/orders/{id}")
    String destroyOrder(@PathVariable String id){
        orderRepository.deleteById(id);
        return "Borrado Exitoso!";
    }

    @GetMapping("/ordersEmail/{userEmail}")
    List<Order> listOrderByEmail(@PathVariable String userEmail){
        if (!orderRepository.findByUserEmail(userEmail).isEmpty()){
            return orderRepository.findByUserEmail(userEmail);
        }
        throw new personNotFoundException("No se encontró una persona con el Email: " + userEmail);
    }
}
