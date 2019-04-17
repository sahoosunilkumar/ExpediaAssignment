package com.expedia.assignment.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.expedia.assignment.common.ViewModelFactory;
import com.expedia.assignment.search.di.SearchViewModelModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = SearchViewModelModule.class)
public abstract class ViewModelModule {


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
