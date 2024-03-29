package com.expedia.assignment.networking.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.util.Log;

import com.expedia.assignment.networking.model.ApiResponse;
import com.expedia.assignment.networking.model.IResponse;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Base class for Network request
 *
 * @param <Request>
 * @param <Response>
 */
public abstract class BaseRepository<Request, Response> {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MediatorLiveData<IResponse<Response>> liveDataResponse = new MediatorLiveData<>();

    public LiveData<IResponse<Response>> getResponse() {
        return liveDataResponse;
    }

    private CompositeDisposable getDisposables() {
        return disposables;
    }

    public void execute(final Request request) {
        getDisposables().add(onExecute(request));
    }

    protected abstract Disposable onExecute(Request request);

    protected void onError(Throwable throwable) {
        Log.e("sunil", "sunil error " + throwable);
        liveDataResponse.postValue(new ApiResponse<>(throwable));
        onCleared();
    }

    protected void onSuccess(Response response) {
        liveDataResponse.postValue(new ApiResponse<>(response));
        onCleared();
    }

    public final void onCleared() {
        disposables.clear();
    }

    protected void onProgress(Disposable disposable) {
        liveDataResponse.postValue(new ApiResponse<>(Status.IN_PROGRESS));
    }
}
