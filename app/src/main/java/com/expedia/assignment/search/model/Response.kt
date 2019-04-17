package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("venues")
    @Expose
    var venues: List<Venue>? = null
    @SerializedName("geocode")
    @Expose
    var geocode: Geocode? = null

}
