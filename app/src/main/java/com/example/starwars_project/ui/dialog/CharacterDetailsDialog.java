package com.example.starwars_project.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.starwars_project.R;
import com.example.starwars_project.databinding.CharacterDetailsDialogFragmentBinding;
import com.example.starwars_project.model.Character;
import com.example.starwars_project.viewmodel.CharacterViewModel;
import com.example.starwars_project.viewmodel.CharacterViewModelFactory;

import java.util.List;

public class CharacterDetailsDialog extends DialogFragment {

    private CharacterDetailsDialogFragmentBinding mBinding;
    private CharacterViewModel mViewModel;
    private final Character character;

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

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.getStarships(character.getStarships()).observe(this, this::setUi);
    }

    private void createListView(List<String> items) {
        ListView starshipsList = mBinding.characterStarships;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mBinding.getRoot().getContext(),
                        android.R.layout.simple_list_item_1,
                        items);
        starshipsList.setAdapter(adapter);
    }

    private void setViewModel() {
        mViewModel = new ViewModelProvider(this,
                new CharacterViewModelFactory()).get(CharacterViewModel.class);
    }

    private void setUi(List<String> starships) {
        mBinding.characterName.setText(character.getName());
        createListView(starships);
    }
}
