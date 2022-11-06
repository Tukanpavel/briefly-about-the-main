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

    @Insert
    void insertAll(ThemeCard ... themeCards);

    @Insert
    void insertList(List<ThemeCard> themeCards);

    @Delete
    void delete(ThemeCard themeCard);

    @Query("Select * from ThemeCard where theme_name in(:theme)")
    LiveData<List<ThemeCard>> getThemeCardsByTheme(String theme);

    @Query("Delete from ThemeCard")
    void deleteAll();

    @Query("Select distinct theme_name from ThemeCard order by random() limit :amount")
    LiveData<List<String>> getRandomCardsByAmount(int amount);

    @Query("Select url from ThemeCard where text = :text")
    LiveData<String> getUrlByText(String text);

    @Query("Select * from ThemeCard join ThemeCardToTag on id = (Select idTag from ThemeCardToTag where idTag = (Select idTag from Tag where tag_name in (:tagName)))")
    LiveData<List<ThemeCard>> getThemeCardsByTag(String tagName);

    @Insert
    void insert(ThemeCard themeCard);
}
