package by.gomel.marseille.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.Serializable
import java.util.*


@Entity(tableName="goods")
data class Goods (
    @ColumnInfo(name="category")
    var category: GoodsCategory,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="price")
    var price: Double,

    @ColumnInfo(name="imageUrl")
    var imageUrl: String,

    @ColumnInfo(name="description")
    var description: String,

    @ColumnInfo(name="ingredients")
    var ingredients: String,

    @ColumnInfo(name="formats")
    var formats: String,

    @ColumnInfo(name="use")
    var use: String,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    var uid: String = UUID.randomUUID().toString()
): Serializable {

    constructor() : this(GoodsCategory.ISRAEL, "", 0.0,"","","", "", "")

}



enum class GoodsCategory(
    val title: String
) {
    ISRAEL("Израиль"),
    ITALY("Италия")
}

class GoodsCategoryTypeConverter {
    @TypeConverter
    fun toGoodsCategory(name: String) = GoodsCategory.valueOf(name)

    @TypeConverter
    fun fromGoodsCategory(category: GoodsCategory) = category.name
}