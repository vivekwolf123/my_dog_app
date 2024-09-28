package com.client.vivekwolf.android.core_dog_data.entity

import com.google.gson.annotations.SerializedName

data class DogInfoEntity(
    @SerializedName("name")
    val name: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("race")
    val race: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("weight")
    val weight: Double
)
