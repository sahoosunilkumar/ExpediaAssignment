package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Bounds {

    @SerializedName("ne")
    @Expose
    var ne: Ne? = null
    @SerializedName("sw")
    @Expose
    var sw: Sw? = null

}
