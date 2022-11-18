package com.Max.bam.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String birthDate;

    public String gender;

    public String eMail;


    public User(String name, String birthDate, String gender, String eMail) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.eMail = eMail;
    }
}
