package by.gomel.marseille.core.base.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


open class SchedulersProvider(
        val io: Scheduler,
        val ui: Scheduler
)

class MainSchedulersProvider : SchedulersProvider(Schedulers.io(), AndroidSchedulers.mainThread())