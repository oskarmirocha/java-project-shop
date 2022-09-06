package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javashopproject.shoplibrary.base.Detail;
import pl.javashopproject.shoplibrary.repos.DetailRepo;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailController {

    @Autowired
    DetailRepo detailRepo;


    @GetMapping("/")
    public List<Detail> getAll(){
        return detailRepo.getAll();
    }

    @GetMapping("/{id}")
    public Detail getById(@PathVariable("id") int id){
        return detailRepo.getById(id);
    }
}