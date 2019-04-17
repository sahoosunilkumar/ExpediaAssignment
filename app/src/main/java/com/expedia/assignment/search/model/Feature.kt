package com.expedia.assignment.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Feature {

    @SerializedName("cc")
    @Expose
    var cc: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("displayName")
    @Expose
    var displayName: String? = null
    @SerializedName("matchedName")
    @Expose
    var matchedName: String? = null
    @SerializedName("highlightedName")
    @Expose
    var highlightedName: String? = null
    @SerializedName("woeType")
    @Expose
    var woeType: Int? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("longId")
    @Expose
    var longId: String? = null
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry? = null

}
