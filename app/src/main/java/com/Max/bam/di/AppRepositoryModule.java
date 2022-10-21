package com.Max.bam.di;

import com.Max.bam.ui.theme.ThemeRepository;
import com.Max.bam.ui.theme.ThemeRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class AppRepositoryModule {
    @Binds
    public abstract ThemeRepository provideThemeCardRepository(ThemeRepositoryImpl impl);
}
