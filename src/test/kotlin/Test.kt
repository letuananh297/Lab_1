import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.assertThrows

import org.junit.jupiter.api.assertDoesNotThrow

internal class AddressKtTest {
    @Test
    fun Test_parseAddress() {
        val address_1 = ""
        assertThrows<IllegalArgumentException> {
            parseAddresses(address_1)
        }

        val address_2 = """
        1. 197343, Санкт Петербург, ул. Торжковская, д. 15
        2. 420097, Казань, ул. Красная позиция, д. 6
        3. 125840, Москва, ул. Вилиса Лациса, д. 14
    """.trimIndent()
        assertDoesNotThrow {
            parseAddresses(address_2)
        }
        val list_addresses_2 = parseAddresses(address_2)
        val list_addresses_3: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        for (i in 0 .. 2) {
            assertEquals(list_addresses_2[i].index, list_addresses_3[i].index)
            assertEquals(list_addresses_2[i].city, list_addresses_3[i].city)
            assertEquals(list_addresses_2[i].street, list_addresses_3[i].street)
            assertEquals(list_addresses_2[i].house, list_addresses_3[i].house)
        }
    }

    @Test
    fun Test_biggest_index() {
        val list_addresses_1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            biggest_index(list_addresses_1)
        }

        val list_addresses_2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address_2 = biggest_index(list_addresses_2)
        assertDoesNotThrow {
            biggest_index(list_addresses_2)
        }
        assertEquals(address_2, list_addresses_2.maxByOrNull { it.index })
    }

    @Test
    fun Test_smallest_index() {
        val list_addresses_1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            smallest_index(list_addresses_1)
        }

        val list_addresses_2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address_2 = smallest_index(list_addresses_2)
        assertDoesNotThrow {
            smallest_index(list_addresses_2)
        }
        assertEquals(address_2, list_addresses_2.minByOrNull { it.index })
    }

    @Test
    fun Test_longest_street() {
        val list_addresses_1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            longest_street(list_addresses_1)
        }

        val list_addresses_2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address_2 = longest_street(list_addresses_2)
        assertDoesNotThrow {
            longest_street(list_addresses_2)
        }
        assertEquals(address_2, list_addresses_2.maxByOrNull { it.street.length })
    }

    @Test
    fun Test_shortest_street() {
        val list_addresses_1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            shortest_street(list_addresses_1)
        }

        val list_addresses_2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address_2 = shortest_street(list_addresses_2)
        assertDoesNotThrow {
            shortest_street(list_addresses_2)
        }
        assertEquals(address_2, list_addresses_2.minByOrNull { it.street.length })
    }
}