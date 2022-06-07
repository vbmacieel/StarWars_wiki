package com.example.starwars_project.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsRetrofitServiceImpl {

    private final static String BASE_URL = "https://swapi.dev/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstace() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
