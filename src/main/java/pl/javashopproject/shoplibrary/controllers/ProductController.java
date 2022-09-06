package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.javashopproject.shoplibrary.base.Product;
import pl.javashopproject.shoplibrary.repos.ProductRepo;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;


    @GetMapping("/products")
    public List<Product> getAll(){
        return productRepo.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable("id") int id){
        return productRepo.getById(id);
    }
}