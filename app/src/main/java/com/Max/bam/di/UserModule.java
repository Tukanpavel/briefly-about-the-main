package com.Max.bam.di;

import com.Max.bam.ui.user.UserRepository;
import com.Max.bam.ui.user.UserRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public abstract class UserModule {
    @Binds
    public abstract UserRepository provideUserRepository(UserRepositoryImpl impl);
}
