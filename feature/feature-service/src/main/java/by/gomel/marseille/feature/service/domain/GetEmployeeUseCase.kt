package by.gomel.marseille.feature.service.domain

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable


class GetEmployeeUseCase(
        private val repository: IRepository
) {

    fun getEmployeeFilteredByNameAsync(category: ServiceCategory): Observable<List<Employee>>
        = repository.employees().get(category)
            .flatMap { list ->
                Observable.fromIterable(list)
                        .sorted(compareBy { it.name })
                        .toList()
                        .toObservable()
            }
            .onErrorReturn { emptyList() }
            .async()

}