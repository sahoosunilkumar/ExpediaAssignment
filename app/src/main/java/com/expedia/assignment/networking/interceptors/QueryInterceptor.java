package com.expedia.assignment.networking.interceptors;

import com.expedia.assignment.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class QueryInterceptor implements Interceptor {
    private static final String KEY_CLIENT_ID = "client_id";
    private static final String KEY_CLIENT_SECRET = "client_secret";
    private static final String KEY_CLIENT_VERSION = "v";
    private final String version;

    public QueryInterceptor(String version) {
        this.version = version;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(KEY_CLIENT_ID, BuildConfig.ClientId)
                .addQueryParameter(KEY_CLIENT_SECRET, BuildConfig.ClientSecret)
                .addQueryParameter(KEY_CLIENT_VERSION, this.version)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
