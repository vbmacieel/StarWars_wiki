package com.example.starwars_project.model;

import com.google.gson.annotations.SerializedName;

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
        return starships;
    }
}
