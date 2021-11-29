package com.snacktime.order.controllers;

import com.snacktime.order.exceptions.personNotFoundException;
import com.snacktime.order.models.Person;
import com.snacktime.order.repositories.OrderRepository;
import com.snacktime.order.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/addOrder")
    String addOrder(@RequestBody Person person ){
        Person person1 = personRepository.findById(person.getUserEmail()).orElse(null);
        if (person1 == null) {
            person = new Person(person.getUserEmail(), person.getLastOrder());
            personRepository.save(person);
            return "Creacion Exitosa!";
        }
        System.out.println("datos traidos de mongo");
        System.out.println(person1.getUserEmail());
        System.out.println(person1.getOrders());
        System.out.println("datos del usuario");
        System.out.println(person.getUserEmail());
        System.out.println(person.getLastOrder());
        person1.addOrder(person.getLastOrder());
        personRepository.save(person1);
        return "Actualizacion Exitosa!";
    }

    @GetMapping("/ordersByEmail/{email}")
    String listOrder(@PathVariable String email){
        Person person = personRepository.findById(email).orElseThrow(
                () -> new personNotFoundException("Persona con email " + email + " no encontrada" )
        );
        return "hola";
    }
}
