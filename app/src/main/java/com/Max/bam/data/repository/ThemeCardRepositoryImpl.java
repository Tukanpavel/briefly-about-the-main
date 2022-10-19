package com.Max.bam.data.repository;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.AppDatabase;
import com.Max.bam.data.dao.ThemeCardDao;
import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

import javax.inject.Inject;


public class ThemeCardRepositoryImpl implements ThemeCardRepository {
    private final ThemeCardDao themeCardDao;
    private final LiveData<List<ThemeCard>> themeCardsLiveData;

    @Inject
    public ThemeCardRepositoryImpl(ThemeCardDao themeCardDao) {
        this.themeCardDao = themeCardDao;
        themeCardsLiveData = themeCardDao.getAll();
    }

    @Override
    public LiveData<List<ThemeCard>> getThemeCardsLiveData() {
        return themeCardsLiveData;
    }

    @Override
    public void insert(ThemeCard themeCard) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            themeCardDao.insert(themeCard);
        });
    }
}
