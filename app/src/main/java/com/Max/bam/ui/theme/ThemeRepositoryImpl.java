package com.Max.bam.ui.theme;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.AppDatabase;
import com.Max.bam.data.dao.ThemeCardDao;
import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

import javax.inject.Inject;


public class ThemeRepositoryImpl implements ThemeRepository {
    private final ThemeCardDao themeCardDao;
    private final LiveData<List<ThemeCard>> themeCardsLiveData;

    @Inject
    public ThemeRepositoryImpl(ThemeCardDao themeCardDao) {
        this.themeCardDao = themeCardDao;
        themeCardsLiveData = themeCardDao.getAll();
    }

    @Override
    public LiveData<List<ThemeCard>> getThemeCardsLiveData() {
        return themeCardsLiveData;
    }

    @Override
    public LiveData<List<ThemeCard>> getThemeCardsByTheme(String theme) {
        return themeCardDao.getThemeCardsByTheme(theme);
    }

    @Override
    public LiveData<List<String>> getRandomThemeCardsByAmount(int amount) {
        return themeCardDao.getRandomCardsByAmount(amount);
    }

    @Override
    public void insert(ThemeCard themeCard) {
        AppDatabase.databaseWriteExecutor.execute(() -> themeCardDao.insert(themeCard));
    }

    //TODO: implement theme randomization for RandomCard
    @Override
    public void updateRandomData() {

    }
}
