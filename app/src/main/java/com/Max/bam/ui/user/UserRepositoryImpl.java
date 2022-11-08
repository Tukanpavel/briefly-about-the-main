package com.Max.bam.ui.user;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.dao.UserDao;
import com.Max.bam.data.entity.User;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;

    @Inject
    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public LiveData<Long> addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public LiveData<User> getUser(String email, String password) {
        return userDao.getUser(email,password);
    }
}
