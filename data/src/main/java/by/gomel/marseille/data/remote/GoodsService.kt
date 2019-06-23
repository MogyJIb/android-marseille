package by.gomel.marseille.data.remote

import by.gomel.marseille.data.models.Goods
import io.reactivex.Observable
import retrofit2.http.GET


interface GoodsService {

    @GET("goods")
    fun getAll(): Observable<List<Goods>>

}