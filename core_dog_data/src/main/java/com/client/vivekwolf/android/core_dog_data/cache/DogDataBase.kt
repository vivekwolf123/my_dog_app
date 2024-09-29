package com.client.vivekwolf.android.core_dog_data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity

@Database(entities = [DogInfoEntity::class], version = 1)
@TypeConverters(DogTypeConverter::class)
abstract class DogDataBase : RoomDatabase() {
    abstract fun dogInfoDao(): DogInfoDao
}
