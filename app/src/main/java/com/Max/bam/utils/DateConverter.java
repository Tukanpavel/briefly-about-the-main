package com.Max.bam.utils;

import androidx.loader.app.LoaderManager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public abstract class DateConverter {
    public static LocalDateTime convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
