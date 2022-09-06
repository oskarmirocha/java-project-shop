package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javashopproject.shoplibrary.base.Order;
import pl.javashopproject.shoplibrary.repos.OrderRepo;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;


    @GetMapping("")
    public List<Order> getAll(){
        return orderRepo.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") int id){
        return orderRepo.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Order> orders){
        return orderRepo.save(orders);
    }
}
