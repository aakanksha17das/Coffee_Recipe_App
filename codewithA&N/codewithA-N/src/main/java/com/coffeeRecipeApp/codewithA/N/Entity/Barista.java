package com.coffeeRecipeApp.codewithA.N.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Barista {

    @Id
    @GeneratedValue
    private int baristaId;

    private String baristaName;
    private String baristaImageUrl;
    private float baristaRating;

    public Barista() {
    }

    public Barista(int baristaId, String baristaName, String baristaImageUrl, float baristaRating) {
        this.baristaId = baristaId;
        this.baristaName = baristaName;
        this.baristaImageUrl = baristaImageUrl;
        this.baristaRating = baristaRating;
    }

    public int getBaristaId() {
        return baristaId;
    }

    public void setBaristaId(int baristaId) {
        this.baristaId = baristaId;
    }

    public String getBaristaName() {
        return baristaName;
    }

    public void setBaristaName(String baristaName) {
        this.baristaName = baristaName;
    }

    public String getBaristaImageUrl() {
        return baristaImageUrl;
    }

    public void setBaristaImageUrl(String baristaImageUrl) {
        this.baristaImageUrl = baristaImageUrl;
    }

    public float getBaristaRating() {
        return baristaRating;
    }

    public void setBaristaRating(float baristaRating) {
        this.baristaRating = baristaRating;
    }


}
