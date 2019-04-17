package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResponse {

    @SerializedName("meta")
    @Expose
    var meta: Meta? = null
    @SerializedName("response")
    @Expose
    var response: Response? = null

}
