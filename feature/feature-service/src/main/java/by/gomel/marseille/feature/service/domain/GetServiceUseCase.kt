package by.gomel.marseille.feature.service.domain

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable


class GetServiceUseCase(
        private val repository: IRepository
) {

    fun getServiceFilteredByNameAsync(category: ServiceCategory): Observable<List<Service>>
            = repository.services().get(category)
            .flatMap { list ->
                Observable.fromIterable(list)
                        .sorted(compareBy { service -> service.name })
                        .toList()
                        .toObservable()
            }
            .onErrorReturn { emptyList() }
            .async()

}