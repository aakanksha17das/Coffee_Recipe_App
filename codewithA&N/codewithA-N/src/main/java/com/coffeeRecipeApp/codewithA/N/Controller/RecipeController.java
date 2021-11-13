package com.coffeeRecipeApp.codewithA.N.Controller;

import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import com.coffeeRecipeApp.codewithA.N.Service.RecipeService;
import com.coffeeRecipeApp.codewithA.N.Service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController 
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity getRecipeList(){
        List<Recipe> recipes = recipeService.getAllRecipes();

        // Creating a response map
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("recipies", recipes);

        return new ResponseEntity(responseMap, HttpStatus.OK);
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
