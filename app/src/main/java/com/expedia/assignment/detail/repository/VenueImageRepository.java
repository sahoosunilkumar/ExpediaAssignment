package com.expedia.assignment.detail.repository;


import com.expedia.assignment.detail.model.GetVenueImageResponse;
import com.expedia.assignment.networking.api.APIService;
import com.expedia.assignment.networking.api.BaseRepository;
import com.expedia.assignment.search.model.Venue;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public final class VenueImageRepository extends BaseRepository<Venue, GetVenueImageResponse> {

    private Scheduler schedulerIo;
    private Scheduler schedulerMain;
    private APIService apiService;

    @Inject
    VenueImageRepository(
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

    protected Disposable onExecute(final Venue venue) {
        return apiService
                .getVenueImage(venue.getId())
                .subscribeOn(schedulerIo)
                .observeOn(schedulerMain)
                .doOnSubscribe(this::onProgress)
                .subscribe(this::onComplete, this::onError);
    }

    private void onComplete(Response<GetVenueImageResponse> listResponse) {
        if (listResponse.isSuccessful()) {
            onSuccess(listResponse.body());
        } else {
            onError(new Exception(listResponse.message()));
        }
    }

}
