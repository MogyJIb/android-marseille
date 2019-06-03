package by.gomel.marseille.feature.service.domain

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable


class GetServiceCategoriesUseCase(
        private val repository: IRepository
) {

    fun getCategoriesFilteredByNameAsync(): Observable<List<ServiceCategory>>
            = repository.services().categories()
                    .onErrorReturn { emptyList() }
                    .async()

}