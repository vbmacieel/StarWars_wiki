package com.example.starwars_project.api;

import com.example.starwars_project.model.CharacterRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarWarsRetrofitService {

    @GET("people")
    Call<CharacterRequest> listCharacters();

    @GET("starships/{id}")
    Call<CharacterRequest> listCharacterDetails(@Path("id") List<Integer> starships);
}
