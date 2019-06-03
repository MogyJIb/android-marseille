package by.gomel.marseille.data.repository


interface IRepository {

    fun goods(): GoodsRepository
    fun services(): ServiceRepository
    fun employees(): EmployeeRepository

}

