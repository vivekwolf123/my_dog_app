package com.client.vivekwolf.android.core_dog_data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity

@Dao
interface DogInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeDogInfoList(dogInfoEntity: List<DogInfoEntity>)

    @Query("SELECT * from dog_info_table")
    suspend fun getDogInfoList(): List<DogInfoEntity>?
}
