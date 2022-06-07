package com.example.starwars_project.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.starwars_project.databinding.CharacterDetailsDialogFragmentBinding;
import com.example.starwars_project.model.Character;
import com.example.starwars_project.viewmodel.CharacterViewModel;
import com.example.starwars_project.viewmodel.CharacterViewModelFactory;

public class CharacterDetailsDialog extends DialogFragment {

    private CharacterDetailsDialogFragmentBinding mBinding;
    private CharacterViewModel mViewModel;
    private Character character;

    public CharacterDetailsDialog(Character character) {
        this.character = character;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = CharacterDetailsDialogFragmentBinding
                .inflate(inflater, container, false);
        setViewModel();
        return mBinding.getRoot();
    }

    private void setViewModel() {
        mViewModel = new ViewModelProvider(this,
                new CharacterViewModelFactory()).get(CharacterViewModel.class);
    }
}
