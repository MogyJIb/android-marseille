package by.gomel.marseille.feature.splash.presentation

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.preferences.DataPrefs
import by.gomel.marseille.data.remote.RemoteApi
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable
import io.reactivex.functions.Function4
import io.reactivex.rxkotlin.plusAssign
import java.util.*
import java.util.concurrent.TimeUnit


class SplashPresenter(
        connectionReceiver: ConnectionReceiver,
        private val repository: IRepository,
        private val api: RemoteApi,
        private val dataPrefs: DataPrefs
) : BasePresenter<SplashContract.View>(connectionReceiver), SplashContract.Presenter {

    override fun initData() {
        if (dataPrefs.needUpdate()) {
            updateData()
        } else {
            disposables += Observable.fromCallable {  }
                .delay(2, TimeUnit.SECONDS)
                .async()
                .subscribe( {
                    view?.onDataLoadFinished()
                }, this::handleError)
        }
    }

    private fun updateData() {
        disposables += Observable
            .zip(
                updateServices(),
                updateEmployees(),
                updateGoods(),
                updateCompanyAbout(),
                Function4<Unit, Unit, Unit, Unit, Unit> { _, _, _, _ -> Unit }
            )
            .async()
            .subscribe( {
                dataPrefs.updateByCurrentTime()
                view?.onDataLoadFinished()
            }, this::handleError)
    }

    private fun updateEmployees()
        = repository.employees().clear()
            .flatMap { api.employeesService.getAll() }
            .flatMap{ employees ->
                employees.forEach { it.uid = UUID.randomUUID().toString() }
                repository.employees().add(*employees.toTypedArray())
            }
            .flatMap{ Observable.just(Unit) }

    private fun updateServices()
        = repository.services().clear()
            .flatMap { api.servicesService.getAll() }
            .flatMap{ services ->
                services.forEach { it.uid = UUID.randomUUID().toString() }
                repository.services().add(*services.toTypedArray())
            }
            .flatMap{ Observable.just(Unit) }

    private fun updateGoods()
        = repository.goods().clear()
            .flatMap { api.goodsService.getAll() }
            .flatMap{ goods ->
                goods.forEach { it.uid = UUID.randomUUID().toString() }
                repository.goods().add(*goods.toTypedArray())
            }
            .flatMap{ Observable.just(Unit) }

    private fun updateCompanyAbout()
        = repository.companyAbout().clear()
            .flatMap { api.companyAboutService.get() }
            .flatMap{ companyAbout ->
                companyAbout.uid = UUID.randomUUID().toString()
                repository.companyAbout().add(companyAbout)
            }
            .flatMap{ Observable.just(Unit) }

}