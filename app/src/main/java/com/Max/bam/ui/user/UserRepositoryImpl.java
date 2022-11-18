package com.Max.bam.ui.user;

import androidx.lifecycle.LiveData;

import com.Max.bam.data.dao.UserDao;
import com.Max.bam.data.entity.User;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance().getReference().getDatabase();

    @Inject
    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        firebaseDatabase.getReference().child("users").child(user.name).setValue(user);
        userDao.addUser(user);
    }

    @Override
    public LiveData<User> getUser(String email) {
        return userDao.getUser(email);
    }
}
