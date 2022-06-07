package com.example.starwars_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Character {

    @SerializedName("name")
    private String name;

    @SerializedName("starships")
    private List<String> starships;

    public String getName() {
        return name;
    }

    public List<String> getStarships() {
        List<String> starshipUrlList = new ArrayList<>();
        for (String starship : this.starships) {
            String starshipUrl = starship.substring(starship.lastIndexOf("/") + 1);
            starshipUrlList.add(starshipUrl);
        }
        return starshipUrlList;
    }
}
