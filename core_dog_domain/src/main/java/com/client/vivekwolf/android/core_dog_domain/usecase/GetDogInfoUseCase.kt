package com.client.vivekwolf.android.core_dog_domain.usecase

import com.client.vivekwolf.android.core_base.DataResult
import com.client.vivekwolf.android.core_base.EntityToModelMapper
import com.client.vivekwolf.android.core_base.ErrorType
import com.client.vivekwolf.android.core_dog_data.DogDataRepository
import com.client.vivekwolf.android.core_dog_data.entity.DogInfoEntity
import com.client.vivekwolf.android.core_dog_domain.model.DogInfoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetDogInfoUseCase @Inject constructor(private val dogDataRepository: DogDataRepository) {

    suspend operator fun invoke(): Flow<DataResult<List<DogInfoModel>, ErrorType>> {
        return dogDataRepository.getDogInfo().map { result ->
            when (result) {
                is DataResult.Success -> {
                    val dogInfoModels = result.data?.let {
                        EntityToModelMapper(
                            entityClass = DogInfoEntity::class,
                            fromEntity = { entity: DogInfoEntity ->
                                DogInfoModel(
                                    name = entity.name,
                                    age = entity.age,
                                    race = entity.race,
                                    gender = entity.gender,
                                    weight = entity.weight
                                )
                            }
                        ).mapEntityToModel(it)
                    } as List<DogInfoModel>

                    DataResult.Success(dogInfoModels)
                }

                is DataResult.Error -> {
                    DataResult.Error(result.error)
                }
            }
        }
    }
}
