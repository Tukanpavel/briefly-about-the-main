package com.Max.bam.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class ThemeCard {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "theme_name")
    public String themeName;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "url")
    public String url;

    public ThemeCard(@NotNull String themeName, @NotNull String text, @NotNull String url) {
        this.themeName = themeName;
        this.text = text;
        this.url = url;
    }
}
