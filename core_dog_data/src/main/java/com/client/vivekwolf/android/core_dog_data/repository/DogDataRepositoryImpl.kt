package com.client.vivekwolf.android.core_dog_data.repository

import com.client.vivekwolf.android.core_base.DataResult
import com.client.vivekwolf.android.core_base.ErrorType
import com.client.vivekwolf.android.core_dog_data.DogDataRepository
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity

internal class DogDataRepositoryImpl : DogDataRepository {

    override suspend fun getDogInfo(): DataResult<List<DogInfoEntity>, ErrorType> {
        TODO("Not yet implemented")
    }
}
