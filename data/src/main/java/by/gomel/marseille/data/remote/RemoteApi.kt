package by.gomel.marseille.data.remote

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RemoteApi(
    gson: Gson,
    okHttpClient: OkHttpClient
) {

    private val retrofit: Retrofit

    val goodsService: GoodsService
        get() = retrofit.create(GoodsService::class.java)
    val employeesService: EmployeesService
        get() = retrofit.create(EmployeesService::class.java)
    val companyAboutService: CompanyAboutService
        get() = retrofit.create(CompanyAboutService::class.java)
    val servicesService: ServicesService
        get() = retrofit.create(ServicesService::class.java)

    companion object {
        const val BASE_URL = "http://marseille.mycloud.by/"
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

}