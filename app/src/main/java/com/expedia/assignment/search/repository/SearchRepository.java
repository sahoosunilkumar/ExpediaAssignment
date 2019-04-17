package com.expedia.assignment.search.repository;


import com.expedia.assignment.networking.api.APIService;
import com.expedia.assignment.networking.api.BaseRepository;
import com.expedia.assignment.search.model.ForecastRequest;
import com.expedia.assignment.search.model.SearchResponse;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public final class SearchRepository extends BaseRepository<ForecastRequest, SearchResponse> {

    private Scheduler schedulerIo;
    private Scheduler schedulerMain;
    private APIService apiService;

    @Inject
    SearchRepository(
            @Named("io")
                    Scheduler schedulerIo,
            @Named("main")
                    Scheduler schedulerMain,
            APIService apiService
    ) {
        this.schedulerIo = schedulerIo;
        this.schedulerMain = schedulerMain;
        this.apiService = apiService;

    }

    protected Disposable onExecute(final ForecastRequest requestModel) {

        return apiService
                .search(requestModel.getLocation(), requestModel.getQuery())
                .subscribeOn(schedulerIo)
                .observeOn(schedulerMain)
                .subscribe(this::onComplete, this::onError);
    }

    private void onComplete(Response<SearchResponse> listResponse) {
        if (listResponse.isSuccessful()) {
            onSuccess(listResponse.body());
        } else {
            onError(new Exception(listResponse.message()));
        }
    }
}
