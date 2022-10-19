package com.Max.bam.data.repository;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

public interface ThemeCardRepository {
    public LiveData<List<ThemeCard>> getThemeCardsLiveData();
    public void insert(ThemeCard themeCard);
    }
