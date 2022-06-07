package com.example.starwars_project.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.starwars_project.api.StarWarsRetrofitService;
import com.example.starwars_project.api.StarWarsRetrofitServiceImpl;
import com.example.starwars_project.model.CharacterRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarWarsRepository {

    private final StarWarsRetrofitService service;

    public StarWarsRepository() {
        this.service = StarWarsRetrofitServiceImpl
                .getRetrofitInstace().create(StarWarsRetrofitService.class);
    }

    public Call<CharacterRequest> getCharacterList() {
        return service.listCharacters();
    }

    public Call<CharacterRequest> getCharacterDetails(List<Integer> starships) {
        return service.listCharacterDetails(starships);
    }
}
