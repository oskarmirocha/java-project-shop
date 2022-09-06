package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javashopproject.shoplibrary.base.Detail;
import pl.javashopproject.shoplibrary.repos.DetailRepo;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailController {

    @Autowired
    DetailRepo detailRepo;


    @GetMapping("")
    public List<Detail> getAll(){
        return detailRepo.getAll();
    }

    @GetMapping("/{id}")
    public Detail getById(@PathVariable("id") int id){
        return detailRepo.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Detail> details){
        return detailRepo.save(details);
    }

}