package pl.javashopproject.shoplibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.javashopproject.shoplibrary.base.Detail;
import pl.javashopproject.shoplibrary.repos.DetailRepo;

import java.util.List;
@Secured("ADMIN")
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

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Detail updatedDetail){
        Detail detail = detailRepo.getById(id);

        if(detail != null){
            detail.setId_order(updatedDetail.getId_order());
            detail.setId_product(updatedDetail.getId_product());
            detail.setAmount(updatedDetail.getAmount());

            detailRepo.update(detail);

            return 1;
        }else{
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return detailRepo.delete(id);
    }

}