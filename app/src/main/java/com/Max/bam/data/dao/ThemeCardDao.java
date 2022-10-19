package com.Max.bam.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.Max.bam.data.entity.ThemeCard;

import java.util.List;

@Dao
public interface ThemeCardDao {
    @Query("Select * from ThemeCard")
    LiveData<List<ThemeCard>> getAll();

    @Query("Select text from ThemeCard where theme_name = :theme")
    LiveData<List<String>> getAllTextsByTheme(String theme);

    @Insert
    void insertAll(ThemeCard ... themeCards);

    @Delete
    void delete(ThemeCard themeCard);

    @Query("Delete from ThemeCard")
    void deleteAll();

    @Insert
    void insert(ThemeCard themeCard);
}
