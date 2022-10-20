package com.Max.bam.ui.theme;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

public interface ThemeRepository {
    LiveData<List<ThemeCard>> getThemeCardsLiveData();
    LiveData<List<ThemeCard>> getThemeCardsByTheme(String theme);
    void insert(ThemeCard themeCard);

    void updateRandomData();
}
