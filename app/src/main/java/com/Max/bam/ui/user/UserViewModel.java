package com.Max.bam.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.Max.bam.data.entity.User;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserViewModel extends ViewModel {
    private final UserRepository mUserRepository;


    @Inject
    public UserViewModel(UserRepository mUserRepository) {
        this.mUserRepository = mUserRepository;
    }

    public LiveData<Long> addUser(User user) {
        return mUserRepository.addUser(user)    ;
    }

    public LiveData<User> getUser(String email, String password) {
        return mUserRepository.getUser(email, password);
    }
}
