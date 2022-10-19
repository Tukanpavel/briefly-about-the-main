package com.Max.bam.ui.theme_text;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.Max.bam.data.entity.ThemeCard;
import com.Max.bam.ui.theme_card.ThemeCardRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ThemeTextViewModel extends ViewModel {
    private ThemeCardRepository mRepository;
    private LiveData<List<ThemeCard>> themeCards;

    @Inject
    public ThemeTextViewModel(ThemeCardRepository themeCardRepository) {
        mRepository = themeCardRepository;
        themeCards = mRepository.getThemeCardsLiveData();
    }
}
