package com.Max.bam.data.entity;

import androidx.room.Entity;

@Entity(primaryKeys = {"id", "idTag"})
public class ThemeCardToTag {
    public int id;
    public int idTag;
}