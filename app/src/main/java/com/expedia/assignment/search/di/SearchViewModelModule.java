package com.expedia.assignment.search.di;

import android.arch.lifecycle.ViewModel;

import com.expedia.assignment.di.module.ViewModelKey;
import com.expedia.assignment.search.viewmodel.SearchViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class SearchViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsItemListViewModel(SearchViewModel viewModel);

    @Provides
    @Named("sourceFormat")
    static DateFormat providesSourceFormat() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    }

    @Provides
    @Named("targetFormat")
    static DateFormat providesTargetFormat() {
        return new SimpleDateFormat("EEEE", Locale.ENGLISH);
    }
}
