package by.gomel.marseille.data.remote

import by.gomel.marseille.data.models.Service
import io.reactivex.Observable
import retrofit2.http.GET


interface ServicesService {

    @GET("services")
    fun getAll(): Observable<List<Service>>

}