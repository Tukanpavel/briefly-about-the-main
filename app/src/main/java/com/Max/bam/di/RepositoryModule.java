package com.Max.bam.di;

import com.Max.bam.data.repository.ThemeCardRepository;
import com.Max.bam.data.repository.ThemeCardRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public abstract class RepositoryModule {
    @Binds
    public abstract ThemeCardRepository provideThemeCardRepository(ThemeCardRepositoryImpl impl);
}
