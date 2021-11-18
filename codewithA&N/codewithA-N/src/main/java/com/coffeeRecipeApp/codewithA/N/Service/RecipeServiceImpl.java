package com.coffeeRecipeApp.codewithA.N.Service;

import com.coffeeRecipeApp.codewithA.N.Entity.Instruction;
import com.coffeeRecipeApp.codewithA.N.Entity.Recipe;
import com.coffeeRecipeApp.codewithA.N.Repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public List<Recipe> getAllRecipes(){
        return recipeRepo.findAll();
    }

    @Override
    public Recipe getRecipeWithId(Integer recipeId) {
        Optional<Recipe> recipe = recipeRepo.findById(recipeId);

        if(!recipe.isPresent()) return null;

        return recipe.get();
    }

    // Returns a list of recipes that conform to the query parameters passed in
    @Override
    public List<Recipe> getRecipesWithQueries(String name) {
        List<Recipe> allRecipes = this.recipeRepo.findAll();
        List<Recipe> recipes = new ArrayList<Recipe>();

        if(name != null) {
            for(Recipe recipe: allRecipes){
                if(recipe.getTitle().equals(name))
                    recipes.add(recipe);
            }
        }

        return recipes;
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

        List<Instruction> instructionList = new ArrayList<>();
//        Instruction instruction = new Instruction(1,"Go through the ingredient list");
//        Instruction instruction2 = new Instruction(2,"Heat Some Milk In A Pan");

//        instructionList.add(instruction);
//        instructionList.add(instruction2);
          recipe.setInstructions(instructionList);

            double sum = 0.0;
            double avg = 0.0;

            List<Double> avgRating = recipe.getRatingsList();
            if (avgRating.size() > 0) {
                    for (Double rating :
                            avgRating) {
                        sum += rating;
                    }
                    avg = sum / avgRating.size();
                    //Rounding Off To 2 decimal places
                    double roundOffAvg = Math.round(avg * 100.00) / 100.00;
                    recipe.setCurrentRating(roundOffAvg);


            }

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
