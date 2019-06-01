package by.gomel.marseille.feature.splash.presentation

import by.gomel.marseille.core.base.view.BaseContract

interface SplashContract {

    interface View : BaseContract.View {

        fun onDataLoadFinished()

    }

    interface Presenter : BaseContract.Presenter {

        fun initData()

    }

}