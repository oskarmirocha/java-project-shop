package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.javashopproject.shoplibrary.base.Order;
import pl.javashopproject.shoplibrary.repos.OrderRepo;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepo orderRepo;


    @GetMapping("/orders")
    public List<Order> getAll(){
        return orderRepo.getAll();
    }

    @GetMapping("/orders/{id}")
    public Order getById(@PathVariable("id") int id){
        return orderRepo.getById(id);
    }
}
