package by.gomel.marseille.data.repository

import by.gomel.marseille.data.database.CompanyDtoDao
import by.gomel.marseille.data.models.CompanyAboutDto
import io.reactivex.Observable


class CompanyAboutRepository(
        private val companyDtoDao: CompanyDtoDao
) {
    fun get(): Observable<CompanyAboutDto> =
        Observable.fromCallable { companyDtoDao.get().first() }

    fun add(vararg CompanyAboutDto: CompanyAboutDto): Observable<Unit>
            = Observable.fromCallable { companyDtoDao.insert(*CompanyAboutDto) }

    fun clear() = Observable.fromCallable { companyDtoDao.clear() }

}