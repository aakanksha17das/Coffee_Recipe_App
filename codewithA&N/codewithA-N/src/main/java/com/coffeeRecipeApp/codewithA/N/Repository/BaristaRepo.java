package com.coffeeRecipeApp.codewithA.N.Repository;

import com.coffeeRecipeApp.codewithA.N.Entity.Barista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaristaRepo extends JpaRepository<Barista,Integer> {
}
