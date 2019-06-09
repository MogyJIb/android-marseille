package by.gomel.marseille.core.base.utils

import android.content.Context
import android.net.ConnectivityManager

class ConnectionReceiver(
        context: Context
) {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun existInternetConnection(): Boolean = connectivityManager.activeNetworkInfo?.isConnected ?: false

}