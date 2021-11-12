package com.coffeeRecipeApp.codewithA.N.Service;

import com.coffeeRecipeApp.codewithA.N.Entity.Barista;
import java.util.List;

public interface BaristaService{
    List<Barista> getAllBaristas();
    void addBarista(Barista barista);
    List<Barista> getTopBaristas();
}
