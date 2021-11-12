/*package com.coffeeRecipeApp.codewithA.N.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CaffineAmount {

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Id
    @GeneratedValue
    private int sequence;

    private float small;
    private float medium;
    private float large;

    @OneToOne(mappedBy = "sequence")
    private Recipe recipe;

    public CaffineAmount() {
    }

    public CaffineAmount(float small, float medium, float large) {
        this.small = small;
        this.medium = medium;
        this.large = large;

    }

    public float getSmall() {
        return small;
    }

    public void setSmall(float small) {
        this.small = small;
    }

    public float getMedium() {
        return medium;
    }

    public void setMedium(float medium) {
        this.medium = medium;
    }

    public float getLarge() {
        return large;
    }

    public void setLarge(float large) {
        this.large = large;
    }
}*/
