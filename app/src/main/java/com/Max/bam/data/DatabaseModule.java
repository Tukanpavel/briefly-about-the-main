package com.Max.bam.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.Max.bam.data.dao.ThemeCardDao;
import com.Max.bam.data.data_example.ThemeCardsPrepopulator;
import com.Max.bam.data.entity.ThemeCard;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    private AppDatabase database;

    @Provides
    @Singleton
    public ThemeCardDao provideThemeCardDao(AppDatabase appDatabase) {
        return appDatabase.themeCardDao();
    }


    @Provides
    @Singleton
    public AppDatabase provideDatabase(@ApplicationContext Context appContext) {
        return Room.databaseBuilder(appContext,
                        AppDatabase.class, "app_database")
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        AsyncTask.execute(() -> {
                            ThemeCard themeCard = new ThemeCard("Кот", "Смешной кот", "https://www.boredpanda.com/blog/wp-content/uploads/2022/07/Cat-Virus-Exe-Funny-Pics-188-62c3dd4206b72__700.jpg");
                            database = AppDatabase.getDatabase(appContext);
                            database.themeCardDao().insertList(ThemeCardsPrepopulator.getThemeCards());
                            database.themeCardDao().insert(themeCard);
                        });
                    }
                })
                .build();
    }
}
