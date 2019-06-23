package by.gomel.marseille.data.preferences

import android.content.Context
import java.util.*


private const val NAME = "update_data_prefs"
private const val TIME_KEY = "time_key"
private const val UPDATE_PERIOD: Long = 86400000       /** One day **/

class DataPrefs(
        context: Context
) : BasePrefs(context, NAME) {

    fun updateByCurrentTime() {
        this[TIME_KEY] = Calendar.getInstance().timeInMillis
    }

    fun needUpdate(): Boolean {
        val saved: Long = this[TIME_KEY]
        val current = Calendar.getInstance().timeInMillis
        return current - saved > UPDATE_PERIOD
    }

}