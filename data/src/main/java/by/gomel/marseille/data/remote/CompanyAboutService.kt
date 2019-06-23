package by.gomel.marseille.data.remote

import by.gomel.marseille.data.models.CompanyAboutDto
import io.reactivex.Observable
import retrofit2.http.GET


interface CompanyAboutService {

    @GET("company_about")
    fun get(): Observable<CompanyAboutDto>

}