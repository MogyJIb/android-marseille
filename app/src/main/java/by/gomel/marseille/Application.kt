package by.gomel.marseille

import android.app.Application
import by.gomel.marseille.KoinDi
import org.koin.android.ext.android.startKoin


class MarseilleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, KoinDi.modules)
    }

}