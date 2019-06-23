package by.gomel.marseille.feature.about.presentation.detail

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.CompanyAboutDto


interface DetailContract {

    interface View : BaseContract.View {
        fun updateCompanyAbout(companyAboutDto: CompanyAboutDto)
    }

    interface Presenter : BaseContract.Presenter {
        fun initCompanyAbout()
    }

}