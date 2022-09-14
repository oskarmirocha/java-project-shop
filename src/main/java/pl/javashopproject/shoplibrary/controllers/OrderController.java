package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.javashopproject.shoplibrary.base.Order;
import pl.javashopproject.shoplibrary.repos.OrderRepo;

import java.util.List;

//@Secured("ADMIN")
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

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Order updatedOrder){
        Order order = orderRepo.getById(id);

        if(order != null){
            order.setId_order(updatedOrder.getId_order());
            order.setDate(updatedOrder.getDate());
            order.setId_client(updatedOrder.getId_client()
            );

            orderRepo.update(order);

            return 1;
        }else{
            return -1;
        }
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return orderRepo.delete(id);
    }
}
