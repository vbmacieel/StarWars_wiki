package com.example.starwars_project.model;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}
