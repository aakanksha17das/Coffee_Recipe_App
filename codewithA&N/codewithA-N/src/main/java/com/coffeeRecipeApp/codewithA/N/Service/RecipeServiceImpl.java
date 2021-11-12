package com.coffeeRecipeApp.codewithA.N.Service;

import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import com.coffeeRecipeApp.codewithA.N.Repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    @Override
    public List<Recipe> getAllRecipes(){
        return recipeRepo.findAll();
    }

    @Override
    public void addRecipe(Recipe recipe){
        recipe.setPublishedDate(new Date());

        String caffineAmountLabel = "SMALL";
        float intake = recipe.getIntakeAmount();
        if(intake > 50.0 && intake < 100.0)
            caffineAmountLabel = "MEDIUM";
        else if(intake > 100.0)
            caffineAmountLabel = "LARGE";

        recipe.setCaffineAmountLabel(caffineAmountLabel);
        this.recipeRepo.save(recipe);
    }

    @Override
    public List<Recipe> getTrendingRecipes(){
        List<Recipe> recipeList = recipeRepo.findAll();
        Collections.sort(recipeList, Comparator.comparing(Recipe :: getCurrentRating).reversed());
        return recipeList;
    }

    @Override
    public List<Recipe> getNewestRecipes(){
        List<Recipe> recipeList = recipeRepo.findAll();
        Collections.sort(recipeList, Comparator.comparing(Recipe :: getPublishedDate).reversed());
        return recipeList;
    }
}