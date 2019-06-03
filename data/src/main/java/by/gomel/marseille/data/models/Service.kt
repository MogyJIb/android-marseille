package by.gomel.marseille.data.models

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import by.gomel.marseille.data.R
import java.io.Serializable
import java.util.*

@Entity(tableName="services")
data class Service (
    @ColumnInfo(name="category")
    var category: ServiceCategory,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="minPrice")
    var minPrice: Double,

    @ColumnInfo(name="maxPrice")
    var maxPrice: Double,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    var uid: String = UUID.randomUUID().toString()
): Serializable {
    val price: Double
        get() = if (maxPrice < 0) minPrice else maxPrice

    constructor() : this(ServiceCategory.HAIR, "", 0.0, 0.0, "")
}



enum class ServiceCategory(
        val title: String,
        val iconUrl: String
) {
    HAIR("Парикмахерские услуги", ""),
    MANICURE("Маникюр", "https://i.imgur.com/INtMaEo.jpg"),
    PEDICURE("Педикюр", ""),
    MAKE_UP("Макияж", ""),
    MAGIC_WHITE("Отбеливание зубов", ""),
    TOOL_SHARPENING("Заточка инструмента", "")
}


class ServiceCategoryTypeConverter {
    @TypeConverter
    fun toServiceCategory(name: String) = ServiceCategory.valueOf(name)

    @TypeConverter
    fun fromServiceCategory(category: ServiceCategory) = category.name
}