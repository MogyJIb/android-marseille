package by.gomel.marseille.data

import by.gomel.marseille.data.database.DatabaseApi
import by.gomel.marseille.data.preferences.DataPrefs
import by.gomel.marseille.data.remote.RemoteApi
import by.gomel.marseille.data.repository.IRepository
import by.gomel.marseille.data.repository.RepositoryApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import java.util.concurrent.TimeUnit


object DataKoinDi {

    val modules = arrayOf(dataModule)

}

private val dataModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }
    single { GsonBuilder().create() as Gson }
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
            .build() as OkHttpClient
    }
    single { RemoteApi(get(), get()) }
    single { DataPrefs(androidContext()) }
}