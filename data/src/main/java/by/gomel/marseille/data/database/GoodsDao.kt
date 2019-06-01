package by.gomel.marseille.data.database

import androidx.room.*
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory


@Dao
interface GoodsDao {

    @Query("SELECT * FROM goods")
    fun getAll(): List<Goods>

    @Query("SELECT * FROM goods WHERE uid IN (:goodsIds)")
    fun get(vararg goodsIds: String): List<Goods>

    @Query("SELECT * FROM goods WHERE category LIKE :category")
    fun get(category: GoodsCategory): List<Goods>

    @Insert
    fun insert(vararg goods: Goods)

    @Update
    fun update(vararg goods: Goods)

    @Delete
    fun delete(vararg goods: Goods)

    @Query("DELETE FROM goods WHERE uid IN (:goodsIds)")
    fun delete(vararg goodsIds: String)

}