package com.example.starwars_project.repository;

import com.example.starwars_project.api.StarWarsRetrofitService;
import com.example.starwars_project.api.StarWarsRetrofitServiceImpl;
import com.example.starwars_project.model.CharacterRequest;

import retrofit2.Call;

public class StarWarsRepository {

    private final StarWarsRetrofitService service;

    public StarWarsRepository() {
        this.service = StarWarsRetrofitServiceImpl
                .getRetrofitInstace().create(StarWarsRetrofitService.class);
    }

    public Call<CharacterRequest> getCharacterList() {
        return service.listCharacters();
    }

    public Call<String> getCharacterStarships(String starshipId) {
        return service.listStarships(starshipId);
    }
}
