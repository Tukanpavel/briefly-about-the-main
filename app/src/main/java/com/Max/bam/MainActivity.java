package com.Max.bam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.Max.bam.data.entity.ThemeCard;
import com.Max.bam.ui.theme_card.ThemeCardListAdapter;
import com.Max.bam.ui.theme_card.ThemeCardsViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ThemeCardsViewModel mThemeCardsViewModel;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ThemeCardListAdapter themeCardListAdapter= new ThemeCardListAdapter(
                new ThemeCardListAdapter.ThemeCardDiff());
        recyclerView.setAdapter(themeCardListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mThemeCardsViewModel = new ViewModelProvider(this).get(ThemeCardsViewModel.class);
        mThemeCardsViewModel.getThemeCards().observe(this, themeCards -> {
            themeCardListAdapter.submitList(themeCards);
        });

        getSupportFragmentManager();
    }
}