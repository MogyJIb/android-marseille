package by.gomel.marseille.core.base.utils

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.async(): Observable<T>
        = this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.async(): Single<T>
        = this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.async(): Flowable<T>
        = this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.async(schedulersProvider: SchedulersProvider): Observable<T>
        = this.subscribeOn(schedulersProvider.io)
            .observeOn(schedulersProvider.ui)

fun <T> Single<T>.async(schedulersProvider: SchedulersProvider): Single<T>
        = this.subscribeOn(schedulersProvider.io)
            .observeOn(schedulersProvider.ui)