package by.gomel.marseille.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName="employees")
data class Employee (
    @ColumnInfo(name="category")
    var category: ServiceCategory,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="position")
    var position: String,

    @ColumnInfo(name="imageUrl")
    var imageUrl: String,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    var uid: String = UUID.randomUUID().toString()
): Serializable {

    constructor() : this(ServiceCategory.HAIR, "", "",  "")

}