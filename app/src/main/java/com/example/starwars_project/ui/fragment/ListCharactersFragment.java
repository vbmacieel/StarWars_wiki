package com.example.starwars_project.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars_project.adapter.CharactersRecyclerViewAdapter;
import com.example.starwars_project.databinding.ListCharactersFragmentLayoutBinding;
import com.example.starwars_project.model.CharacterRequest;

public class ListCharactersFragment extends Fragment {

    private ListCharactersFragmentLayoutBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = ListCharactersFragmentLayoutBinding
                .inflate(inflater, container, false);
        setRecyclerView();
        return mBinding.getRoot();
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = mBinding.recyclerviewCharacters;
        CharactersRecyclerViewAdapter adapter =
                new CharactersRecyclerViewAdapter(new CharacterRequest());
        recyclerView.setLayoutManager(new LinearLayoutManager(mBinding.getRoot().getContext()));
        recyclerView.setAdapter(adapter);
    }

}
