package com.Max.bam.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.Max.bam.data.entity.User;

@Dao
public interface UserDao {
    @Query("Select * from user u where u.eMail = :email")
    LiveData<User> getUser(String email);

    @Insert
    void addUser(User user);
}
