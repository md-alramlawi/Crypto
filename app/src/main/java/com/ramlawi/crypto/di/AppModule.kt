package com.ramlawi.crypto.di

import androidx.transition.Visibility
import com.ramlawi.crypto.common.Constants
import com.ramlawi.crypto.data.remote.CoinApi
import com.ramlawi.crypto.data.repository.CoinRepositoryImpl
import com.ramlawi.crypto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
* Created by Mohammed Alramlawi on 1/9/2022.
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository{
        /**
         * In testing we can create a fake CoinRepository
         */
        return CoinRepositoryImpl(api)
    }
}