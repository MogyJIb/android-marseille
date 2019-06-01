package by.gomel.marseille.data

import by.gomel.marseille.data.database.DatabaseApi
import by.gomel.marseille.data.repository.IRepository
import by.gomel.marseille.data.repository.RepositoryApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


object DataKoinDi {

    val modules = arrayOf(dataModule)

}

private val dataModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }
}