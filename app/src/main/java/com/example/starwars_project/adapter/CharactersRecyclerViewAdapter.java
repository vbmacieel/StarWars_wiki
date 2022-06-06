package com.example.starwars_project.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars_project.databinding.CharacterItemLayoutBinding;
import com.example.starwars_project.model.Character;
import com.example.starwars_project.model.CharacterRequest;

import java.util.List;

public class CharactersRecyclerViewAdapter extends
        RecyclerView.Adapter<CharactersRecyclerViewAdapter.CharactersViewHolder>{

    private List<Character> mCharacterList;

    public CharactersRecyclerViewAdapter(CharacterRequest characterList) {
        this.mCharacterList = characterList.getCharacters();
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterItemLayoutBinding binding = CharacterItemLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharactersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        holder.bind(mCharacterList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCharacterList == null ? 0 : mCharacterList.size();
    }

    static class CharactersViewHolder extends RecyclerView.ViewHolder {
        private final CharacterItemLayoutBinding binding;

        public CharactersViewHolder(@NonNull CharacterItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        protected void bind(Character character) {
            this.binding.characterName.setText(character.getName());
        }
    }
}
