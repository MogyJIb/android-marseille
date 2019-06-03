package by.gomel.marseille.feature.service.domain

import by.gomel.marseille.core.base.utils.catch
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.Service
import io.reactivex.subjects.BehaviorSubject
import java.io.Serializable


class ServiceShoppingCart : Serializable {

    private val cartDtoMap: MutableMap<String, Service> = mutableMapOf()
    var employee: Employee? = null

    val amount: BehaviorSubject<Double> = BehaviorSubject.create()
    val cartDtoList: List<Service>
        get() = cartDtoMap.values.toList()

    fun add(vararg services: Service) {
        services
            .filter { !cartDtoMap.containsKey(it.uid) }
            .forEach { cartDtoMap[it.uid] = it }
        
        updateAmount()
    }

    fun update(vararg services: Service) {
        add(*services)
    }

    fun remove(vararg services: Service) {
        services
            .forEach { cartDtoMap.remove(it.uid) }

        updateAmount()
    }

    fun clear() {
        cartDtoMap.clear()
        employee = null
        updateAmount()
    }

    fun contain(service: Service) = cartDtoMap.containsValue(service)

    private fun updateAmount() {
        val amount =  cartDtoList
            .map { service -> service.price }
            .sum()
        this.amount.onNext(amount)
    }

}