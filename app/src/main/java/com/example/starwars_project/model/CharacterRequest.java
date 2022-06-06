package com.example.starwars_project.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterRequest {

    @SerializedName("results")
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }
}
