package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geocode {

    @SerializedName("what")
    @Expose
    var what: String? = null
    @SerializedName("where")
    @Expose
    var where: String? = null
    @SerializedName("feature")
    @Expose
    var feature: Feature? = null
    @SerializedName("parents")
    @Expose
    var parents: List<Any>? = null

}
