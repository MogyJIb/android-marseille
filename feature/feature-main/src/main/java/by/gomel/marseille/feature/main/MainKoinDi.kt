package by.gomel.marseille.feature.main

import by.gomel.marseille.feature.about.AboutKoinDi
import by.gomel.marseille.feature.goods.GoodsKoinDi


object MainKoinDi {

    val modules = arrayOf(
        *GoodsKoinDi.modules,
        *AboutKoinDi.modules
    )

}