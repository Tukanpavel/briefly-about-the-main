package com.Max.bam.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Tag {
    @PrimaryKey(autoGenerate = true)
    public int idTag;

    @ColumnInfo(name = "tag_name")
    public String tagName;

    public Tag(@NotNull String tagName) {
        this.tagName = tagName;
    }
}
