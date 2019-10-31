package com.khaled.food2fork.di.module

import com.khaled.food2fork.BuildConfig
import com.khaled.food2fork.data.api.Food2ForkApi
import com.khaled.food2fork.ui.home.repository.HomeRepository
import com.khaled.food2fork.ui.home.viewmodel.HomeViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Modules {
    val appComponent = listOf(networkModule, viewModelModule, repositoryModule)
}

val networkModule = module {
    single<Food2ForkApi> {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val apiKeyInterceptor = Interceptor { chain ->
            val request = chain.request()
            val url = request.url()
            val newUrl = url.newBuilder()
                .addQueryParameter(Food2ForkApi.PARAM_API_KEY, Food2ForkApi.API_KEY).build()
            val builder = request.newBuilder()
            builder.url(newUrl)
            chain.proceed(builder.build())
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .connectTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(30000, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiService = retrofit.create(Food2ForkApi::class.java)

        apiService
    }
}

val viewModelModule = module {
    viewModel { HomeViewModel() }
}

val repositoryModule = module {
    single { HomeRepository() }
}