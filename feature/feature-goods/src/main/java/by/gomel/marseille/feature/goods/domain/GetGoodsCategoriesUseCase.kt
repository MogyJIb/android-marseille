package by.gomel.marseille.feature.goods.domain

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable


class GetGoodsCategoriesUseCase(
        private val repository: IRepository
) {

    fun getCategoriesFilteredByNameAsync(): Observable<List<GoodsCategory>>
            = repository.goods().categories()
                    .flatMap { list ->
                        Observable.fromIterable(list)
                                .sorted(compareBy { category -> category.name })
                                .toList()
                                .toObservable()
                    }
                    .onErrorReturn { emptyList() }
                    .async()

}