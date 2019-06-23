package by.gomel.marseille.data.database

import androidx.room.*
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory


@Dao
interface ServiceDao {

    @Query("SELECT * FROM services")
    fun getAll(): List<Service>

    @Query("SELECT * FROM services WHERE category LIKE :category")
    fun get(category: ServiceCategory): List<Service>

    @Insert
    fun insert(vararg services: Service)

    @Query("DELETE FROM services")
    fun clear()

}