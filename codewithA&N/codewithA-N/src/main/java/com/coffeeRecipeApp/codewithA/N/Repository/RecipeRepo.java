package com.coffeeRecipeApp.codewithA.N.Repository;

import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe,Integer> {
}



