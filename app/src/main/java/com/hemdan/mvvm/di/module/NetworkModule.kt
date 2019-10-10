package com.hemdan.mvvm.di.module

import com.hemdan.mvvm.BuildConfig
import com.hemdan.mvvm.data.api.Food2ForkApi
import com.hemdan.mvvm.data.api.Food2ForkApi.Companion.API_KEY
import com.hemdan.mvvm.data.api.Food2ForkApi.Companion.PARAM_API_KEY
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    internal fun provideApiKeyInterceptor(): Interceptor {

        return Interceptor { chain ->
            val request = chain.request()
            val url = request.url()
            val newUrl = url.newBuilder()
                .addQueryParameter(PARAM_API_KEY, API_KEY).build()
            val builder = request.newBuilder()
            builder.url(newUrl)
            chain.proceed(builder.build())
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor, apiKeyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .connectTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(30000, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Food2ForkApi {
        return retrofit.create(Food2ForkApi::class.java)
    }
}