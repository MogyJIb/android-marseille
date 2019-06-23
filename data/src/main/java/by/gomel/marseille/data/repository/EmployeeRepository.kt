package by.gomel.marseille.data.repository

import by.gomel.marseille.data.database.EmployeeDao
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory
import io.reactivex.Observable


class EmployeeRepository(
        private val employeeDao: EmployeeDao
) {
    fun getAll(): Observable<List<Employee>> = Observable.fromCallable { employeeDao.getAll() }

    fun get(vararg employeeIds: String): Observable<List<Employee>>
            = Observable.fromCallable { employeeDao.get(*employeeIds) }

    fun get(category: ServiceCategory): Observable<List<Employee>>
            = Observable.fromCallable { employeeDao.get(category) }

    fun add(vararg employee: Employee): Observable<Unit> = Observable.fromCallable { employeeDao.insert(*employee) }

    fun update(vararg employee: Employee): Observable<Unit>
            = Observable.fromCallable { employeeDao.update(*employee) }

    fun delete(vararg employee: Employee): Observable<Unit>
            = Observable.fromCallable { employeeDao.delete(*employee) }

    fun delete(vararg employeeIds: String): Observable<Unit>
            = Observable.fromCallable { employeeDao.delete(*employeeIds) }

    fun categories(): Observable<List<ServiceCategory>>
            = Observable.fromCallable { ServiceCategory.values().toList() }

    fun clear() = Observable.fromCallable { employeeDao.clear() }

}