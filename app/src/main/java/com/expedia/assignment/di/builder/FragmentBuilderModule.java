package com.expedia.assignment.di.builder;

import com.expedia.assignment.search.di.SearchFragmentModule;
import com.expedia.assignment.search.view.SearchFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {
    @SuppressWarnings("unused")
    @ContributesAndroidInjector(modules = SearchFragmentModule.class)
    abstract SearchFragment contributeWeatherForecastFragment();

}
