package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Center {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lng")
    @Expose
    var lng: Double? = null

}
