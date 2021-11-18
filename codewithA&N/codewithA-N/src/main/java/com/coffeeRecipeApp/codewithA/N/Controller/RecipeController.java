package com.coffeeRecipeApp.codewithA.N.Controller;

import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import com.coffeeRecipeApp.codewithA.N.Service.RecipeService;
import com.coffeeRecipeApp.codewithA.N.Service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController 
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity getRecipeList(@RequestParam(name = "name", required = false) String name) {
        List<Recipe> recipes;

        if(name != null) {
            recipes = recipeService.getRecipesWithQueries(name);
        } else {
            recipes = recipeService.getAllRecipes();
        }

        // Creating a response map
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("recipes", recipes);

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
        response.put("recipes", trendingRecipes);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/recipes/latest")
    public ResponseEntity<Object> fetchLatestRecipes() {
        List<Recipe> latestRecipes = recipeService.getNewestRecipes();
        if (latestRecipes.size() > 0) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("recipes", latestRecipes);
            return new ResponseEntity<Object>(responseBody, HttpStatus.OK);
        }
        return new ResponseEntity<>("NO LATEST RECIPES !!",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("recipes/{recipeId}")
    public ResponseEntity<Recipe> fetchRecipeWithId(@PathVariable Integer recipeId) {
        Recipe fetchedRecipe = this.recipeService.getRecipeWithId(recipeId);

        if(fetchedRecipe == null) throw new RuntimeException("The recipe you searched for isn't present");

        return new ResponseEntity<Recipe>(fetchedRecipe, HttpStatus.OK);
    }

//    @GetMapping("/recipes")
//    public ResponseEntity<Object> fetchRecipesWithQueries(@RequestParam(value = "name") String name){
//        return new ResponseEntity<>("You searched with name : " + name, HttpStatus.OK);
//    }

}