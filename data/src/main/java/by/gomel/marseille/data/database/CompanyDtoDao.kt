package by.gomel.marseille.data.database

import androidx.room.*
import by.gomel.marseille.data.models.CompanyAboutDto


@Dao
interface CompanyDtoDao {

    @Query("SELECT * FROM company_about")
    fun get(): List<CompanyAboutDto>

    @Insert
    fun insert(vararg companyAboutDto: CompanyAboutDto)

    @Query("DELETE FROM company_about")
    fun clear()

}