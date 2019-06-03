package by.gomel.marseille.data.repository

import by.gomel.marseille.data.database.DatabaseApi

class RepositoryApi(
        private val db: DatabaseApi
) : IRepository {

    override fun goods() = GoodsRepository(db.goodsDao())
    override fun services() = ServiceRepository(db.serviceDao())
    override fun employees() = EmployeeRepository(db.employeeDao())

}