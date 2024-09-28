package com.client.vivekwolf.android.core_dog_domain.di

import com.client.vivekwolf.android.core_dog_data.DogDataRepository
import com.client.vivekwolf.android.core_dog_domain.usecase.GetDogInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DogDomainDiModule {

    @Provides
    @ViewModelScoped
    fun provideGetDogInfoUseCase(dogDataRepository: DogDataRepository) =
        GetDogInfoUseCase(dogDataRepository)
}
