package com.example.starwars_project.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starwars_project.model.CharacterRequest;
import com.example.starwars_project.repository.StarWarsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    private final StarWarsRepository repository;

    private MutableLiveData<CharacterRequest> _characterRequestList;
    private LiveData<CharacterRequest> characterRequestList;

    public CharacterViewModel() {
        repository = new StarWarsRepository();
        _characterRequestList = new MutableLiveData<>();
    }

    public LiveData<CharacterRequest> getCharacterRequestList() {
        return characterRequestList;
    }

    public void getCharacters() {
        repository.getCharacterList().enqueue(new Callback<CharacterRequest>() {
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

    public void getCharactersDetails(List<Integer> starships) {
        Call<CharacterRequest> characterDetails = repository.getCharacterDetails(starships);
        characterDetails.enqueue(new Callback<CharacterRequest>() {
            @Override
            public void onResponse(Call<CharacterRequest> call, Response<CharacterRequest> response) {

            }

            @Override
            public void onFailure(Call<CharacterRequest> call, Throwable t) {

            }
        });
    }
}
