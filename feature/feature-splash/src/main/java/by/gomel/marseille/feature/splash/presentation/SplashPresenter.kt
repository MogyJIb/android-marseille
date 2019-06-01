package by.gomel.marseille.feature.splash.presentation

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.repository.IRepository
import by.gomel.marseille.feature.splash.domain.fakeProducts
import by.gomel.marseille.feature.splash.domain.fakeServices
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val repository: IRepository
) : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun initData() {
        disposables += Observable.zip(updateServices(), updateProducts(), BiFunction<Unit, Unit, Unit> { _, _ -> Unit })
            .delay(3, TimeUnit.SECONDS)
            .async()
            .subscribe { view?.onDataLoadFinished() }
    }

    private fun updateServices()
        = repository.services().getAll()
            .flatMap { services ->
                if (services.isEmpty())
                    repository.services().add(*fakeServices().toTypedArray())
                else
                    Observable.just(Unit)
            }

    private fun updateProducts()
        = repository.goods().getAll()
            .flatMap { products ->
                if (products.isEmpty())
                    repository.goods().add(*fakeProducts().toTypedArray())
                else
                    Observable.just(Unit)
            }

}