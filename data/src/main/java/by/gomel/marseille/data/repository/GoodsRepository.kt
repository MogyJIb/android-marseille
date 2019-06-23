package by.gomel.marseille.data.repository

import by.gomel.marseille.data.database.GoodsDao
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory
import io.reactivex.Observable


class GoodsRepository(
        private val goodsDao: GoodsDao
) {
    fun getAll(): Observable<List<Goods>> = Observable.fromCallable { goodsDao.getAll() }

    fun get(vararg goodsIds: String): Observable<List<Goods>>
            = Observable.fromCallable { goodsDao.get(*goodsIds) }

    fun get(category: GoodsCategory): Observable<List<Goods>>
            = Observable.fromCallable { goodsDao.get(category) }

    fun add(vararg goods: Goods): Observable<Unit> = Observable.fromCallable { goodsDao.insert(*goods) }

    fun update(vararg goods: Goods): Observable<Unit>
            = Observable.fromCallable { goodsDao.update(*goods) }

    fun delete(vararg goods: Goods): Observable<Unit>
            = Observable.fromCallable { goodsDao.delete(*goods) }

    fun delete(vararg goodsIds: String): Observable<Unit>
            = Observable.fromCallable { goodsDao.delete(*goodsIds) }

    fun categories(): Observable<List<GoodsCategory>>
            = Observable.fromCallable { GoodsCategory.values().toList() }

    fun clear() = Observable.fromCallable { goodsDao.clear() }

}