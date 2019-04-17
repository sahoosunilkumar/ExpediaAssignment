package com.expedia.assignment.networking.api;

import com.expedia.assignment.detail.model.GetVenueImageResponse;
import com.expedia.assignment.search.model.SearchResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("/v2/venues/search?")
    Single<Response<SearchResponse>> search(@Query("near") String location, @Query("query") String query);

    @GET("/v2/venues/{id}/photos?")
    Single<Response<GetVenueImageResponse>> getVenueImage(@Path("id") String id);
}