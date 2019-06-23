package by.gomel.marseille.feature.about.presentation.detail

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.feature.about.domain.GetAboutCompanyUseCase
import io.reactivex.rxkotlin.plusAssign


class DetailPresenter(
    connectionReceiver: ConnectionReceiver,
    private val getAboutCompanyUseCase: GetAboutCompanyUseCase
) : BasePresenter<DetailContract.View>(connectionReceiver), DetailContract.Presenter {

    override fun initCompanyAbout() {
        disposables += getAboutCompanyUseCase()
            .subscribe({
                    companyAbout -> view?.updateCompanyAbout(companyAbout)
            }, this::handleError)
    }

}