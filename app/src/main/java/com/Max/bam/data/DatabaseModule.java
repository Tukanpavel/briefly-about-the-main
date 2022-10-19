package com.Max.bam.data;

import android.content.Context;

import androidx.room.Room;

import com.Max.bam.data.dao.ThemeCardDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    public ThemeCardDao provideThemeCardDao(AppDatabase appDatabase) {
        return appDatabase.themeCardDao();
    }


    @Provides
    @Singleton
    public AppDatabase provideDatabase(@ApplicationContext Context appContext) {
        return Room.databaseBuilder(appContext,
                        AppDatabase.class, "app_database")
                .build();
    }
}
