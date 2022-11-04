package com.Max.bam.data.entity;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class TagByThemeCard {
    @Embedded public Tag tag;
    @Relation(
            parentColumn = "idTag",
            entityColumn = "id",
            associateBy = @Junction(ThemeCardToTag.class)
    )
    public List<ThemeCard> Themes;
}
