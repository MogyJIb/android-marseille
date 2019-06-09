package by.gomel.city.test.data

import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory
import org.junit.Test
import kotlin.test.assertEquals


class ServiceTest {

    @Test
    fun correct_price_with_max_price() {
        val service = Service(ServiceCategory.MAGIC_WHITE, "test", 12.0, 15.0)

        val expected = 15.0
        val actual = service.price

        assertEquals(expected, actual)
    }

    @Test
    fun correct_price_without_max_price() {
        val service = Service(ServiceCategory.MAGIC_WHITE, "test", 12.0, -1.0)

        val expected = 12.0
        val actual = service.price

        assertEquals(expected, actual)
    }

}

