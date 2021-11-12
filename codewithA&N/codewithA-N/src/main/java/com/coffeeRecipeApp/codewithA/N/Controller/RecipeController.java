package com.coffeeRecipeApp.codewithA.N.Controller;

import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import com.coffeeRecipeApp.codewithA.N.Service.RecipeService;
import com.coffeeRecipeApp.codewithA.N.Service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getRecipeList(){
        return recipeService.getAllRecipes();
    }

    @PostMapping("/recipe/save")
    public void createRecipe(@RequestBody Recipe recipe){
        recipeService.addRecipe(recipe);
    }

    @GetMapping("/recipes/trending")
    public List<Recipe> fetchTrendingRecipes(){
        return recipeService.getTrendingRecipes();
    }

    @GetMapping("/recipes/latest")
    public List<Recipe> fetchLatestRecipes(){
        return recipeService.getNewestRecipes();
    }

}
