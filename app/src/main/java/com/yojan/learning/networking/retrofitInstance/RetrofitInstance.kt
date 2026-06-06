package com.yojan.learning.networking.retrofitInstance

import com.example.privateambulance.data.networking.remote.DateDeserializer
import com.example.privateambulance.data.networking.remote.HeaderManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yojan.learning.BuildConfig
import com.yojan.learning.networking.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val HEADER_COOKIE = "cookie"
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(Date::class.java, DateDeserializer())
            .create()
    }

    @Provides
    @Singleton
    fun provideLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        logging: HttpLoggingInterceptor,
        headerManager: HeaderManager
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()

                headerManager.headers?.forEach { (key, value) ->
                    value?.let { requestBuilder.addHeader(key, it) }
                }

                chain.proceed(requestBuilder.build())
            }
            .addInterceptor { chain ->
                val response = chain.proceed(chain.request())

                if (response.isSuccessful && response.code == 200 && headerManager.headers == null) {
                    val map = HashMap<String, String?>()

                    map[HEADER_COOKIE] = response.headers("Set-Cookie").map { it.split(";").first() }.joinToString(";")

                    headerManager.headers = map
                }

                response
            }

            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}