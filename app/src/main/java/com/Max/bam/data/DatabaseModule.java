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
                            ThemeCard themeCard = new ThemeCard(
                                    "Кот",
                                    "Смешной кот",
                                    "https://sun9-52.userapi.com/impg/XVyKXHXYsca8hhZ9WWn5_vvKndNR3K-btWQqDg/RgQO2rWCrkw.jpg?size=1600x738&quality=95&sign=70e3c9fa83fc69b93dd1ad7439878db4&type=album");
                            database = AppDatabase.getDatabase(appContext);
                            database.themeCardDao().insertList(ThemeCardsPrepopulator.getThemeCards());
                            database.themeCardDao().insert(themeCard);
                        });
                    }
                })
                .build();
    }
}
