package com.Max.bam.di;

import com.Max.bam.ui.theme_card.ThemeCardRepository;
import com.Max.bam.ui.theme_card.ThemeCardRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public abstract class RepositoryModule {
    @Binds
    public abstract ThemeCardRepository provideThemeCardRepository(ThemeCardRepositoryImpl impl);
}
