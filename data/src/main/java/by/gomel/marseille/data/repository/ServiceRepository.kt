package by.gomel.marseille.data.repository

import by.gomel.marseille.data.database.ServiceDao
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory
import io.reactivex.Observable


class ServiceRepository(
        private val serviceDao: ServiceDao
) {
    fun getAll(): Observable<List<Service>> =
        Observable.fromCallable { serviceDao.getAll() }

    fun get(category: ServiceCategory): Observable<List<Service>>
            = Observable.fromCallable { serviceDao.get(category) }

    fun add(vararg services: Service): Observable<Unit> = Observable.fromCallable { serviceDao.insert(*services) }

    fun categories(): Observable<List<ServiceCategory>>
            = Observable.fromCallable { listOf(
                ServiceCategory.HAIR, ServiceCategory.MANICURE, ServiceCategory.PEDICURE,
                ServiceCategory.TOOL_SHARPENING, ServiceCategory.MAGIC_WHITE, ServiceCategory.MAKE_UP
            ) }

    fun clear() = Observable.fromCallable { serviceDao.clear() }

}