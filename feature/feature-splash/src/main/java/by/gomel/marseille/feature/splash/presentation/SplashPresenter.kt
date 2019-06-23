package by.gomel.marseille.feature.splash.presentation

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.preferences.DataPrefs
import by.gomel.marseille.data.remote.RemoteApi
import by.gomel.marseille.data.repository.IRepository
import by.gomel.marseille.feature.splash.domain.fakeEmployees
import by.gomel.marseille.feature.splash.domain.fakeServices
import io.reactivex.Observable
import io.reactivex.functions.Function3
import io.reactivex.rxkotlin.plusAssign
import java.util.*


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
            view?.onDataLoadFinished()
        }
    }

    private fun updateData() {
        disposables += Observable
            .zip(
                updateServices(),
                updateEmployees(),
                updateGoods(),
                Function3<Unit, Unit, Unit, Unit> { _, _, _ -> Unit }
            )
            .async()
            .subscribe( {
                dataPrefs.updateByCurrentTime()
                view?.onDataLoadFinished()
            }, this::handleError)
    }

    private fun updateServices()
        = repository.services().getAll()
            .flatMap { services ->
                if (services.isEmpty())
                    repository.services().add(*fakeServices().toTypedArray())
                else
                    Observable.just(Unit)
            }

    private fun updateEmployees()
        = repository.employees().getAll()
            .flatMap { employees ->
                if (employees.isEmpty())
                    repository.employees().add(*fakeEmployees().toTypedArray())
                else
                    Observable.just(Unit)
            }

    private fun updateGoods()
        = repository.goods().clear()
            .flatMap { api.goodsService.all() }
            .flatMap{ goods ->
                goods.forEach { it.uid = UUID.randomUUID().toString() }
                repository.goods().add(*goods.toTypedArray())
            }
            .flatMap{ Observable.just(Unit) }

}