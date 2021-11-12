package com.coffeeRecipeApp.codewithA.N.Controller;

import com.coffeeRecipeApp.codewithA.N.Entity.Barista;
import com.coffeeRecipeApp.codewithA.N.Service.BaristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaristaController {

    @Autowired
    BaristaService baristaService;

    @GetMapping("/baristas")
    public List<Barista> getAllBaristas(){
        return baristaService.getAllBaristas();
    }

    @PostMapping("/barista/save")
    public void createBarista(@RequestBody Barista barista){
        baristaService.addBarista(barista);
    }

    @GetMapping("/baristas/top")
    public List<Barista> fetchTopBaristas(){
        return baristaService.getTopBaristas();
    }
}
