package com.Max.bam.ui.theme_card;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

public interface ThemeCardRepository {
    LiveData<List<ThemeCard>> getThemeCardsLiveData();
    void insert(ThemeCard themeCard);
    }
