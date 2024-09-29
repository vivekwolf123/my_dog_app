package com.client.vivekwolf.android.core_dog_data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "dog_info_table")
data class DogInfoEntity(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,

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
