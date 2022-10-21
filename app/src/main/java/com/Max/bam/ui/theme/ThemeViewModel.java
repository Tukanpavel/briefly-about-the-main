package com.Max.bam.ui.theme;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.Max.bam.data.entity.ThemeCard;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ThemeViewModel extends ViewModel {
    private final LiveData<List<ThemeCard>> themeCards;
    private final MutableLiveData<String> currentTheme = new MutableLiveData<>();
    private final ThemeRepository mRepository;
    private final LiveData<List<ThemeCard>> themeCardsByName;

    @Inject
    public ThemeViewModel(ThemeRepository themeCardRepository) {
        mRepository = themeCardRepository;
        themeCards = themeCardRepository.getThemeCardsLiveData();
        ThemeCard card = new ThemeCard("bruh", "sheesh");
        insert(card);
        themeCardsByName = Transformations
                .switchMap(currentTheme, mRepository::getThemeCardsByTheme);
    }

    public LiveData<List<ThemeCard>> getThemeCards() {
        return themeCards;
    }

    public LiveData<List<ThemeCard>> getThemeCardsByTheme(String theme) {
        return mRepository.getThemeCardsByTheme(theme);
    }

    public void setCurrentTheme(String theme) {
        currentTheme.setValue(theme);
    }

    public LiveData<List<String>> getRandomThemeCards(int amount) {
        return mRepository.getRandomThemeCardsByAmount(amount);
    }

    public void insert(ThemeCard card) {
        mRepository.insert(card);
    }
}
