package com.expedia.assignment.search.viewmodel

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.widget.ImageView
import com.expedia.assignment.detail.model.GetVenueImageResponse
import com.expedia.assignment.detail.repository.VenueImageRepository
import com.expedia.assignment.formatter.impl.DateStringFormatter
import com.expedia.assignment.networking.model.IResponse
import com.expedia.assignment.search.model.ForecastRequest
import com.expedia.assignment.search.model.SearchResponse
import com.expedia.assignment.search.model.Venue
import com.expedia.assignment.search.repository.SearchRepository
import javax.inject.Inject

class SearchViewModel @Inject
internal constructor(val repository: SearchRepository, val formatter: DateStringFormatter) : ViewModel(), Observer<IResponse<SearchResponse>> {
    val apiResponse = MediatorLiveData<IResponse<SearchResponse>>()
    private val repositoryResponse = MediatorLiveData<IResponse<SearchResponse>>()
    private var request: ForecastRequest? = null
    private val location = "Seattle"

    init {
        repositoryResponse.addSource(repository.response, this)
        apiResponse.addSource(repositoryResponse, this)
    }

    override fun onChanged(listIResponse: IResponse<SearchResponse>?) {
        this.apiResponse.postValue(listIResponse)
    }

    fun execute(query:String) {
            this.request = ForecastRequest(location, query)
            repository.execute(ForecastRequest(location, query))

    }

}
