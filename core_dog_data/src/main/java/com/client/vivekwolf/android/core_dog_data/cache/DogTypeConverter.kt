package com.client.vivekwolf.android.core_dog_data.cache

import androidx.room.TypeConverter
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal class DogTypeConverter {
    @TypeConverter
    fun fromDogInfoEntityList(dogInfoEntityList: List<DogInfoEntity>?): String? {
        if (dogInfoEntityList == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<DogInfoEntity>>() {}.type
        return gson.toJson(dogInfoEntityList, type)
    }

    @TypeConverter
    fun toDogInfoEntityList(dogInfoEntityListString: String?): List<DogInfoEntity>? {
        if (dogInfoEntityListString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<DogInfoEntity>>() {}.type
        return gson.fromJson(dogInfoEntityListString, type)
    }
}
