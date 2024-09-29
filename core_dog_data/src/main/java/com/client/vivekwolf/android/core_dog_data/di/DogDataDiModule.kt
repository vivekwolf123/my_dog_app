package com.client.vivekwolf.android.core_dog_data.di

import android.content.Context
import androidx.room.Room
import com.client.vivekwolf.android.core_dog_data.DogDataRepository
import com.client.vivekwolf.android.core_dog_data.cache.DogDataBase
import com.client.vivekwolf.android.core_dog_data.cache.DogInfoDao
import com.client.vivekwolf.android.core_dog_data.repository.DogDataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DogDataDiModule {

    @Provides
    @Singleton
    fun provideDogInfoDao(dogDataBase: DogDataBase) = dogDataBase.dogInfoDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): DogDataBase {
        return Room.databaseBuilder(
            appContext, DogDataBase::class.java, "dog_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDogDataRepository(dogInfoDao: DogInfoDao): DogDataRepository =
        DogDataRepositoryImpl(dogInfoDao)
}
