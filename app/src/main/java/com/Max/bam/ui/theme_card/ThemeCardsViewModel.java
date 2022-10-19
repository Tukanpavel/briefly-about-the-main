package com.Max.bam.ui.theme_card;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ThemeCardsViewModel extends ViewModel {
    private ThemeCardRepository mRepository;
    private LiveData<List<ThemeCard>> themeCards;

    @Inject
    public ThemeCardsViewModel(ThemeCardRepository themeCardRepository) {
        mRepository = themeCardRepository;
        themeCards = themeCardRepository.getThemeCardsLiveData();
        ThemeCard card = new ThemeCard("bruh", "sheesh");
        insert(card);
    }

    public LiveData<List<ThemeCard>> getThemeCards() {
        return themeCards;
    }

    public void insert(ThemeCard card) {
        mRepository.insert(card);
    }
}
