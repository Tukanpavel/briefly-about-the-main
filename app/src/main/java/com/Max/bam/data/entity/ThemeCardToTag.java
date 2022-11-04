package com.Max.bam.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( primaryKeys = {"id", "idTag"} )
public class ThemeCardToTag {
    public int id;
    public int idTag;
}
