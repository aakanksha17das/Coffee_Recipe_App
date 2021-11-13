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
    public ResponseEntity getRecipeList() {
        List<Recipe> recipes = recipeService.getAllRecipes();

        // Creating a response map
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("recipies", recipes);

        return new ResponseEntity(responseMap, HttpStatus.OK);
    }

    @PostMapping("/recipe/save")
    public void createRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping("/recipes/trending")
    public ResponseEntity<Object> fetchTrendingRecipes() {
        List<Recipe> trendingRecipes = recipeService.getTrendingRecipes();
        Map<String, Object> response = new HashMap<>();
        response.put("trendingRecipes", trendingRecipes);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/recipes/latest")
    public ResponseEntity<Object> fetchLatestRecipes() {
        List<Recipe> latestRecipes = recipeService.getNewestRecipes();
        if (latestRecipes.size() > 0) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("latestRecipes", latestRecipes);
            return new ResponseEntity<Object>(responseBody, HttpStatus.OK);
        }
        return new ResponseEntity<>("NO LATEST RECIPES !!",HttpStatus.INTERNAL_SERVER_ERROR);

    }

}