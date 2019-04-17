package com.expedia.assignment.di.module;

import com.expedia.assignment.networking.api.APIService;
import com.expedia.assignment.networking.interceptors.QueryInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Provides
    @Singleton
    QueryInterceptor providesQueryInterceptor(String version) {
        return new QueryInterceptor(version);
    }

    @Provides
    @Singleton
    String providesVersion() {
        return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(new Date());
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor, QueryInterceptor queryInterceptor) {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(queryInterceptor);
        okHttpClient.addInterceptor(interceptor);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    APIService provideRetrofit(OkHttpClient httpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.foursquare.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(APIService.class);
    }

    @Provides
    @Singleton
    @Named("io")
    Scheduler providesSchedulerIo() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named("main")
    Scheduler providesSchedulerMain() {
        return AndroidSchedulers.mainThread();
    }

}
