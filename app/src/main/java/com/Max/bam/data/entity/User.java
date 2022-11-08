package com.Max.bam.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public LocalDateTime birtDate;

    public String gender;

    public String eMail;

    public String password;

    public User(int id, String name, LocalDateTime birtDate, String gender, String eMail, String password) {
        this.id = id;
        this.name = name;
        this.birtDate = birtDate;
        this.gender = gender;
        this.eMail = eMail;
        this.password = password;
    }
}
