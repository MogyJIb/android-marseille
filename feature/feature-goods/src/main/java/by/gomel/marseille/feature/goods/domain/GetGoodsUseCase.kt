package by.gomel.marseille.feature.goods.domain

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable


class GetGoodsUseCase(
        private val repository: IRepository
) {

    fun getGoodsFilteredByNameAsync(category: GoodsCategory): Observable<List<Goods>>
            = repository.goods().get(category)
            .flatMap { list ->
                Observable.fromIterable(list)
                        .sorted(compareBy { service -> service.name })
                        .toList()
                        .toObservable()
            }
            .onErrorReturn { emptyList() }
            .async()

}