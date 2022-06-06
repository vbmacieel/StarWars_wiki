package com.example.starwars_project.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.starwars_project.R;
import com.example.starwars_project.ui.fragment.ListCharactersFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMainFragment();
    }

    private void initMainFragment() {
        Fragment mainFragment = new ListCharactersFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout_fragment, mainFragment)
                .commit();
    }
}