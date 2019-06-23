package by.gomel.marseille.data.remote

import by.gomel.marseille.data.models.Employee
import io.reactivex.Observable
import retrofit2.http.GET


interface EmployeesService {

    @GET("employees")
    fun getAll(): Observable<List<Employee>>

}