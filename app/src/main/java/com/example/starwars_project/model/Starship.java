package com.example.starwars_project.model;

import com.google.gson.annotations.SerializedName;

public class Starship {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
