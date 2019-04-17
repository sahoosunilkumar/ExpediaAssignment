package com.expedia.assignment.search.model

import com.expedia.assignment.detail.model.GetVenueImageResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Venue {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("location")
    @Expose
    var location: Location? = null
    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null
    @SerializedName("referralId")
    @Expose
    var referralId: String? = null
    @SerializedName("hasPerk")
    @Expose
    var hasPerk: Boolean? = null
    @SerializedName("venuePage")
    @Expose
    var venuePage: VenuePage? = null

    var imageResource: GetVenueImageResponse? = null

}
