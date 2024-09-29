package com.client.vivekwolf.android.core_dog_data.repository

import com.client.vivekwolf.android.core_base.DataResult
import com.client.vivekwolf.android.core_dog_data.DogDataRepository
import com.client.vivekwolf.android.core_dog_data.cache.DogInfoDao
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class DogDataRepositoryImpl @Inject constructor(private val dogInfoDao: DogInfoDao) :
    DogDataRepository {

    override suspend fun storeDogInfo(dogInfoEntity: List<DogInfoEntity>) = flow {
        dogInfoDao.storeDogInfoList(dogInfoEntity)
        emit(DataResult.Success(dogInfoDao.getDogInfoList()))
    }

    override suspend fun getDogInfo() = flow {
        emit(DataResult.Success(dogInfoDao.getDogInfoList()))
    }
}
