package com.example.starwars_project.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CharacterViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CharacterViewModel.class)) {
            return (T) new CharacterViewModel();
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
