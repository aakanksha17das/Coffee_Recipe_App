package com.coffeeRecipeApp.codewithA.N.Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int recipeId;

    @NotNull
    private String title;

    private String description;
    private String sourceBarista;
    private String sourceBaristaId;
    private double currentRating;
    private boolean isBookMarked;
    private String imageUrl;
    private int timeToMake;
    private String brewType;
    private Date publishedDate;
    private int calories;

    @ElementCollection
    private Set<String> ingredients;

    @ElementCollection
    private Set<String> labels;

    @ElementCollection
    private List<Double> ratingsList;

    private float intakeAmount;

    private String caffineAmountLabel;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Instruction> instructions = new ArrayList<>();

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public float getIntakeAmount() {
        return intakeAmount;
    }

    public void setIntakeAmount(float intakeAmount) {
        this.intakeAmount = intakeAmount;
    }

    public String getCaffineAmountLabel() {
        return caffineAmountLabel;
    }

    public void setCaffineAmountLabel(String caffineAmountLabel) {
        this.caffineAmountLabel = caffineAmountLabel;
    }

    public List<Double> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Double> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSourceBarista(String sourceBarista) {
        this.sourceBarista = sourceBarista;
    }

    public void setSourceBaristaId(String sourceBaristaId) {
        this.sourceBaristaId = sourceBaristaId;
    }

    public void setCurrentRating(double currentRating) {
        this.currentRating = currentRating;
    }

    public void setBookMarked(boolean isBookMarked) {
        isBookMarked = isBookMarked;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTimeToMake(int timeToMake) {
        this.timeToMake = timeToMake;
    }

    public void setBrewType(String brewType) {
        this.brewType = brewType;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSourceBarista() {
        return sourceBarista;
    }

    public String getSourceBaristaId() {
        return sourceBaristaId;
    }

    public double getCurrentRating() {
        return currentRating;
    }

    public boolean isBookMarked() {
        return isBookMarked;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCalories() {
        return calories;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public String getBrewType() {
        return brewType;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public Recipe(){
    }

    public Recipe(int recipeId, String title, String description, String sourceBarista, String sourceBaristaId, double currentRating, boolean isBookMarked, String imageUrl, int timeToMake, String brewType, Date publishedDate, int calories, Set<String> ingredients, Set<String> labels, List<Double> ratingsList, float intakeAmount, String caffineAmountLabel) {
        this.recipeId = recipeId;
        this.title = title;
        this.description = description;
        this.sourceBarista = sourceBarista;
        this.sourceBaristaId = sourceBaristaId;
        this.currentRating = currentRating;
        this.isBookMarked = isBookMarked;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.timeToMake = timeToMake;
        this.brewType = brewType;
        this.publishedDate = publishedDate;
        this.calories = calories;
        this.labels = labels;
        this.ratingsList = ratingsList;

        this.intakeAmount = intakeAmount;
        this.caffineAmountLabel = caffineAmountLabel;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sourceBarista='" + sourceBarista + '\'' +
                ", sourceBaristaId='" + sourceBaristaId + '\'' +
                ", currentRating=" + currentRating +
                ", isBookMarked=" + isBookMarked +
                ", imageUrl='" + imageUrl + '\'' +
                ", timeToMake=" + timeToMake +
                ", brewType='" + brewType + '\'' +
                ", publishedDate=" + publishedDate +
                ", calories=" + calories +
                '}';
    }


}


