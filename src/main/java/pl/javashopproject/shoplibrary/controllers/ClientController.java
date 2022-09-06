package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.javashopproject.shoplibrary.base.Client;
import pl.javashopproject.shoplibrary.repos.ClientRepo;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/clients")
    public List<Client> getAll(){
        return clientRepo.getAll();
    }

    @GetMapping("/clients/{id}")
    public Client getById(@PathVariable("id") int id){
        return clientRepo.getById(id);
    }
}