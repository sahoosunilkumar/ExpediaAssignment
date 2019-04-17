package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geometry {

    @SerializedName("center")
    @Expose
    var center: Center? = null
    @SerializedName("bounds")
    @Expose
    var bounds: Bounds? = null

}
