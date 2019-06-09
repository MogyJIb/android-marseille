package by.gomel.city.test.service

import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.domain.ServiceShoppingCart
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ServiceShoppintCartTest {

    @Mock
    private lateinit var employee: Employee

    private lateinit var cart: ServiceShoppingCart

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        cart = ServiceShoppingCart().apply { add(*services) }

        doReturn(ServiceCategory.MAGIC_WHITE)
            .`when`(employee).category
    }

    @Test
    fun success_contain_service() {
        val service = Service(ServiceCategory.MAGIC_WHITE, "test", 10.0, -1.0)
        cart.add(service)

        val expected = true
        val actual = cart.contain(service)

        assertEquals(expected, actual)
    }

    @Test
    fun success_not_contain_service() {
        val expected = false
        val actual = cart.contain(Service())

        assertEquals(expected, actual)
    }

    @Test
    fun success_amount_change_on_add() {
        val price = 30.0
        val expected = cart.amount.value!! + price

        cart.add(Service(ServiceCategory.MAGIC_WHITE, "test", price, -1.0))

        val actual = cart.amount.value!!

        assertEquals(expected, actual)
    }

    @Test
    fun success_clear() {
        cart.employee = employee
        cart.clear()
        assertEquals(cart.employee, null)
        assertTrue { (cart.cartDtoList.isEmpty()) }
    }

}


val services = arrayOf(
    Service(ServiceCategory.MAGIC_WHITE, "test0", 10.0, -1.0),
    Service(ServiceCategory.MAGIC_WHITE, "test1", 10.0, -1.0),
    Service(ServiceCategory.MAGIC_WHITE, "test2", 10.0, -1.0),
    Service(ServiceCategory.MAGIC_WHITE, "test3", 10.0, -1.0),
    Service(ServiceCategory.MAGIC_WHITE, "test4", 10.0, -1.0),
    Service(ServiceCategory.MAGIC_WHITE, "test5", 10.0, -1.0)
)