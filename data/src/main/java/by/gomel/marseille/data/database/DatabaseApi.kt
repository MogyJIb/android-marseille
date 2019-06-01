package by.gomel.marseille.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategoryTypeConverter
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategoryTypeConverter


@Database(entities = [Goods::class, Service::class], version = 1)
@TypeConverters(ServiceCategoryTypeConverter::class, GoodsCategoryTypeConverter::class)
abstract class DatabaseApi : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "marseille_db"

        @JvmStatic
        fun instance(context: Context) =
                Room.databaseBuilder(context, DatabaseApi::class.java, DATABASE_NAME).build()
    }

    abstract fun goodsDao(): GoodsDao
    abstract fun serviceDao(): ServiceDao

}