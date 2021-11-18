package com.coffeeRecipeApp.codewithA.N.Service;


import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import java.util.List;


public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeWithId(Integer recipeId);
    List<Recipe> getRecipesWithQueries(String name);
    void addRecipe(Recipe recipe);
    List<Recipe> getTrendingRecipes();
    List<Recipe> getNewestRecipes();
}
