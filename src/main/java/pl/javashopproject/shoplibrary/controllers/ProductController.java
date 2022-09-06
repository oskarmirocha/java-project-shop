package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javashopproject.shoplibrary.base.Product;
import pl.javashopproject.shoplibrary.repos.ProductRepo;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepo productRepo;


    @GetMapping("")
    public List<Product> getAll(){
        return productRepo.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") int id){
        return productRepo.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Product> products){
        return productRepo.save(products);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Product updatedProduct){
        Product product = productRepo.getById(id);

        if(product != null){
            product.setProduct(updatedProduct.getProduct());
            product.setPrice(updatedProduct.getPrice());

            productRepo.update(product);

            return 1;
        }else{
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return productRepo.delete(id);
    }
}
