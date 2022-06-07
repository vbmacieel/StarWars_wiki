package com.example.starwars_project.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars_project.adapter.CharactersRecyclerViewAdapter;
import com.example.starwars_project.api.StarWarsRetrofitServiceImpl;
import com.example.starwars_project.databinding.ListCharactersFragmentLayoutBinding;
import com.example.starwars_project.model.CharacterRequest;
import com.example.starwars_project.repository.StarWarsRepository;
import com.example.starwars_project.viewmodel.CharacterViewModel;
import com.example.starwars_project.viewmodel.CharacterViewModelFactory;

public class ListCharactersFragment extends Fragment implements CharactersRecyclerViewAdapter.OnClickItem{

    private ListCharactersFragmentLayoutBinding mBinding;
    private CharacterViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = ListCharactersFragmentLayoutBinding
                .inflate(inflater, container, false);
        setViewModel();
        mViewModel.getCharacters();
        return mBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.getCharacterRequestList().observe(this, this::setRecyclerView);
    }

    @Override
    public void onCharacterClick(int position, String name) {
        Toast.makeText(mBinding.getRoot().getContext(), name, Toast.LENGTH_SHORT).show();
    }

    private void setRecyclerView(CharacterRequest characterRequest) {
        RecyclerView recyclerView = mBinding.recyclerviewCharacters;
        CharactersRecyclerViewAdapter adapter =
                new CharactersRecyclerViewAdapter(characterRequest, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mBinding.getRoot().getContext()));
    }

    private void setViewModel() {
        mViewModel = new ViewModelProvider(this,
                new CharacterViewModelFactory()).get(CharacterViewModel.class);
    }
}
