package com.maruf.placeholderapi.data.network


import com.google.gson.annotations.SerializedName

class ResponsePost : ArrayList<ResponsePost.ResponsePostItem>(){
    data class ResponsePostItem(
        @SerializedName("body")
        val body: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("userId")
        val userId: Int?
    )
}