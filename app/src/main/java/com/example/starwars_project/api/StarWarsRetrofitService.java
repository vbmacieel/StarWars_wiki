package com.example.starwars_project.api;

import com.example.starwars_project.model.CharacterRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarWarsRetrofitService {

    @GET("people")
    Call<CharacterRequest> listCharacters();
}
