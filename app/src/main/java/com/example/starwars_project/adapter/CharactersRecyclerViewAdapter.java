package com.example.starwars_project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars_project.databinding.CharacterItemLayoutBinding;
import com.example.starwars_project.model.Character;
import com.example.starwars_project.model.CharacterRequest;

import java.util.List;

public class CharactersRecyclerViewAdapter extends
        RecyclerView.Adapter<CharactersRecyclerViewAdapter.CharactersViewHolder>{

    private final List<Character> mCharacterList;
    private OnClickItem onClickItem;

    public CharactersRecyclerViewAdapter(CharacterRequest characterRequest,
                                         OnClickItem onClickItem) {
        this.mCharacterList = characterRequest.getCharacters();
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterItemLayoutBinding binding = CharacterItemLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharactersViewHolder(binding, mCharacterList, onClickItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersViewHolder holder, int position) {
        holder.bind(mCharacterList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCharacterList == null ? 0 : mCharacterList.size();
    }

    static class CharactersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CharacterItemLayoutBinding binding;
        private List<Character> mCharacterList;
        private OnClickItem listener;

        public CharactersViewHolder(@NonNull CharacterItemLayoutBinding binding,
                                    List<Character> characterList,
                                    OnClickItem onClickItem) {
            super(binding.getRoot());
            this.binding = binding;
            this.mCharacterList = characterList;
            this.listener = onClickItem;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Character character = mCharacterList.get(position);
            listener.onCharacterClick(position, character.getName());
        }

        protected void bind(Character character) {
            this.binding.characterName.setText(character.getName());
        }
    }

    public interface OnClickItem {
        void onCharacterClick(int position, String name);
    }
}
