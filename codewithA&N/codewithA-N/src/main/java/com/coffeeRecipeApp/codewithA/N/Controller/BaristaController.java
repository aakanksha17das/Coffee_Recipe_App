package com.coffeeRecipeApp.codewithA.N.Controller;

import com.coffeeRecipeApp.codewithA.N.Entity.Barista;
import com.coffeeRecipeApp.codewithA.N.Service.BaristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BaristaController {

    @Autowired
    BaristaService baristaService;

    @GetMapping("/baristas")
    public ResponseEntity<Object> getAllBaristas(){
        List<Barista> baristaList = baristaService.getAllBaristas();
        if(baristaList.size() > 0){
            Map<String,Object> responseBody = new HashMap<>();
            responseBody.put("baristas",baristaList);
            return new ResponseEntity<Object>(responseBody, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("No BARISTAS To Display", HttpStatus.OK);
    }

    @PostMapping("/barista/save")
    public void createBarista(@RequestBody Barista barista){
        baristaService.addBarista(barista);
    }

    @GetMapping("/baristas/top")
    public ResponseEntity<Object> fetchTopBaristas(){
        List<Barista> topBaristas = baristaService.getTopBaristas();
        if(topBaristas.size() > 0){
            Map<String,Object> responseBody = new HashMap<>();
            responseBody.put("baristas",topBaristas);
            return new ResponseEntity<Object>(responseBody,HttpStatus.OK);
        }
        return new ResponseEntity<Object>("No Top Baristas!!",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
