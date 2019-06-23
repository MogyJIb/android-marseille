package by.gomel.marseille.data.database

import androidx.room.*
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory


@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employees")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employees WHERE category LIKE :category")
    fun get(category: ServiceCategory): List<Employee>

    @Insert
    fun insert(vararg employees: Employee)

    @Query("DELETE FROM employees")
    fun clear()

}