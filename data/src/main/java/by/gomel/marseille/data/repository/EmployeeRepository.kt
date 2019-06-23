package by.gomel.marseille.data.repository

import by.gomel.marseille.data.database.EmployeeDao
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory
import io.reactivex.Observable


class EmployeeRepository(
        private val employeeDao: EmployeeDao
) {
    fun getAll(): Observable<List<Employee>> = Observable.fromCallable { employeeDao.getAll() }

    fun get(category: ServiceCategory): Observable<List<Employee>>
            = Observable.fromCallable { employeeDao.get(category) }

    fun add(vararg employee: Employee): Observable<Unit> = Observable.fromCallable { employeeDao.insert(*employee) }

    fun categories(): Observable<List<ServiceCategory>>
            = Observable.fromCallable { ServiceCategory.values().toList() }

    fun clear() = Observable.fromCallable { employeeDao.clear() }

}