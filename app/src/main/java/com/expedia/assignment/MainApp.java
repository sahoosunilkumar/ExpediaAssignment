package com.expedia.assignment;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.expedia.assignment.di.components.AppComponent;
import com.expedia.assignment.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MainApp extends MultiDexApplication implements HasActivityInjector {

    private static AppComponent appComponent;


    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .application(this)
                    .build();
        }
        return appComponent;
    }

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }

    private void initializeComponent() {
        getAppComponent().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }
}
