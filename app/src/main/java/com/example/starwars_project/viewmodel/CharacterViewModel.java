package com.example.starwars_project.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starwars_project.model.CharacterRequest;
import com.example.starwars_project.model.Starship;
import com.example.starwars_project.repository.StarWarsRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    private final StarWarsRepository mRepository;

    private final MutableLiveData<CharacterRequest> _characterRequestList;
    private final MutableLiveData<List<String>> characterStarships;
    private LiveData<CharacterRequest> characterRequestList;

    public CharacterViewModel() {
        mRepository = new StarWarsRepository();
        _characterRequestList = new MutableLiveData<>();
        characterStarships = new MutableLiveData<>();
    }

    public void getCharacters() {
        mRepository.getCharacterList().enqueue(new Callback<CharacterRequest>() {
            @Override
            public void onResponse(Call<CharacterRequest> call, Response<CharacterRequest> response) {
                _characterRequestList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CharacterRequest> call, Throwable t) {
                _characterRequestList.postValue(null);
            }
        });
        characterRequestList = _characterRequestList;
    }

    public MutableLiveData<List<String>> getStarships(List<String> starships) {
        Starship starship = new Starship();
        List<String> starshipList = new ArrayList<>();
        for (String starshipItem : starships) {
            mRepository.getCharacterStarships(starshipItem).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    starship.setName(response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    starship.setName(t.getMessage());
                }
            });
            starshipList.add(starship.getName());
        }
        characterStarships.setValue(starshipList);
        return characterStarships;
    }

    public LiveData<CharacterRequest> getCharacterRequestList() {
        return characterRequestList;
    }
}
