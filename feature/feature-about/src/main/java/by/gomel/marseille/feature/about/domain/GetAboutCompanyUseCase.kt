package by.gomel.marseille.feature.about.domain

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.data.models.CompanyAboutDto
import by.gomel.marseille.data.repository.IRepository
import io.reactivex.Observable


class GetAboutCompanyUseCase(
        private val repository: IRepository
) {

    operator fun invoke(): Observable<CompanyAboutDto>
        = repository.companyAbout().get().async()

}