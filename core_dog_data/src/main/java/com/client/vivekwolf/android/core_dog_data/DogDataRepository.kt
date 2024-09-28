package com.client.vivekwolf.android.core_dog_data

import com.client.vivekwolf.android.core_base.DataResult
import com.client.vivekwolf.android.core_base.ErrorType
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity
import kotlinx.coroutines.flow.Flow

interface DogDataRepository {

    suspend fun getDogInfo(): Flow<DataResult<List<DogInfoEntity>, ErrorType>>
}
