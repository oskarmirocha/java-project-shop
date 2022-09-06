package pl.javashopproject.shoplibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

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
