package by.gomel.marseille.feature.main

import by.gomel.marseille.feature.about.AboutKoinDi
import by.gomel.marseille.feature.goods.GoodsKoinDi
import by.gomel.marseille.feature.service.ServiceKoinDi


object MainKoinDi {

    val modules = arrayOf(
        *GoodsKoinDi.modules,
        *AboutKoinDi.modules,
        *ServiceKoinDi.modules
    )

}