package com.expedia.assignment.di.components;

import android.app.Application;

import com.expedia.assignment.MainApp;
import com.expedia.assignment.di.builder.ActivityBuilderModule;
import com.expedia.assignment.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MainApp mainApp);
}