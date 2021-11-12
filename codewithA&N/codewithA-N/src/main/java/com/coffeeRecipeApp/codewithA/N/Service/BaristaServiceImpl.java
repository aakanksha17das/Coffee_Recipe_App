package com.coffeeRecipeApp.codewithA.N.Service;

import com.coffeeRecipeApp.codewithA.N.Entity.Barista;
import com.coffeeRecipeApp.codewithA.N.Repository.BaristaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BaristaServiceImpl implements BaristaService{

    @Autowired
    BaristaRepo baristaRepo;

    @Override
    public List<Barista> getAllBaristas(){
        return baristaRepo.findAll();
    }

    @Override
    public void addBarista(Barista barista){
        this.baristaRepo.save(barista);
    }

    @Override
    public List<Barista> getTopBaristas(){
        List<Barista> baristaList= baristaRepo.findAll();
        Collections.sort(baristaList, Comparator.comparing(Barista::getBaristaRating).reversed());
        return baristaList;
    }
}
