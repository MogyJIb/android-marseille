package by.gomel.marseille.data.preferences

import android.content.Context
import android.content.SharedPreferences


@Suppress("UNCHECKED_CAST")
open class BasePrefs(
        context: Context,
        prepsName: String
) {

    val prefs: SharedPreferences = context.getSharedPreferences(prepsName, Context.MODE_PRIVATE)

    val STRING_DEF = ""
    val BOOLEAN_DEF = false
    val INT_DEF = 0
    val LONG_DEF = 0L
    val STRING_SET_DEF = setOf<String>()

    operator fun set(key: String, value: Any) {
        prefs.edit()?.apply {
            when (value) {
                is String -> putString(key, value)
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                (value as? Set<String>) != null -> putStringSet(key, value as Set<String>?)
                else -> throw UnsupportedOperationException("Operation 'set' for type ${value::class.java} with value '$value' isn't supported")
            }
        }?.apply()
    }
    
    inline operator fun <reified T> get(key: String): T
        = prefs.run {
            when {
                STRING_DEF is T -> getString(key, STRING_DEF) as T
                BOOLEAN_DEF is T -> getBoolean(key, BOOLEAN_DEF) as T
                INT_DEF is T -> getInt(key, INT_DEF) as T
                LONG_DEF is T -> getLong(key, LONG_DEF) as T
                STRING_SET_DEF is T -> getStringSet(key, STRING_SET_DEF) as T
                else -> throw UnsupportedOperationException("Operation 'get' for type ${T::class.java} isn't supported")
            }
        }

    operator fun minusAssign(key: String) = delete(key)

    fun delete(key: String) = prefs.edit().remove(key).apply()

}

