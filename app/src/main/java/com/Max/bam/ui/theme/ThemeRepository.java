package com.Max.bam.ui.theme;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

public interface ThemeRepository {
    LiveData<List<ThemeCard>> getThemeCardsLiveData();
    LiveData<List<ThemeCard>> getThemeCardsByTheme(String theme);

    LiveData<List<ThemeCard>> getThemeCardsByTag(String tagName);

    LiveData<List<String>> getRandomThemeCardsByAmount(int amount);
    LiveData<String> getUrlByText(String text);
    void insert(ThemeCard themeCard);
    void updateRandomData();
}
