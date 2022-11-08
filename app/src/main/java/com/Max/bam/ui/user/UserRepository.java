package com.Max.bam.ui.user;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.entity.User;

public interface UserRepository {
    LiveData<Long> addUser(User user);
    LiveData<User> getUser(String email, String password);
}
