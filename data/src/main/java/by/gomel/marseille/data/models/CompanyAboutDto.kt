package by.gomel.marseille.data.models

import androidx.room.*
import java.io.Serializable
import java.util.*


@Entity(tableName="company_about")
data class CompanyAboutDto(
    @Embedded
    var history: CompanyHistoryDto,
    @Embedded
    var contacts: CompanyContactsDto,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    var uid: String = UUID.randomUUID().toString()
) : Serializable {

    constructor() : this(CompanyHistoryDto(), CompanyContactsDto())

}


data class CompanyHistoryDto(
    @ColumnInfo(name="position")
    var content: String,

    @ColumnInfo(name="historyTitle")
    var title: String
): Serializable {

    constructor() : this("", "")

}


data class CompanyContactsDto(
    @ColumnInfo(name="address")
    var address: String,

    @ColumnInfo(name="imageUrl")
    var imageUrl: String,

    @ColumnInfo(name="companyTitle")
    var title: String,

    @ColumnInfo(name="mapTitle")
    var mapTitle: String,

    @TypeConverters(PhoneNumbersTypeConverter::class)
    @ColumnInfo(name="phoneNumbers")
    var phoneNumbers: List<String>,

    @TypeConverters(ReferencesTypeConverter::class)
    @ColumnInfo(name="references")
    var references: List<ContactReferenceDto>
): Serializable {

    constructor() : this("", "", "", "", emptyList(), emptyList())

}


data class ContactReferenceDto(
    var title: String,
    var imageUrl: String,
    var urlReference: String
): Serializable {

    constructor() : this("", "", "")

}


class PhoneNumbersTypeConverter {
    @TypeConverter
    fun toPhoneNumbers(numbers: String) = numbers.split(",").toList()

    @TypeConverter
    fun fromPhoneNumbers(phoneNumbers: List<String>) = phoneNumbers.joinToString(",")
}

class ReferencesTypeConverter {
    @TypeConverter
    fun toReferences(references: String): List<ContactReferenceDto>
            = references.split(",").map {
                val words = it.split(";")
                ContactReferenceDto(words[0], words[1], words[2])
            }.toList()

    @TypeConverter
    fun fromReferences(references: List<ContactReferenceDto>): String
            = references.joinToString(",") { "${it.title};${it.imageUrl};${it.urlReference}" }
}