import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.assertThrows

import org.junit.jupiter.api.assertDoesNotThrow

internal class AddressKtTest {
    @Test
    fun TestparseAddress() {
        val address1 = ""
        assertThrows<IllegalArgumentException> {
            parseAddresses(address1)
        }

        val address2 = """
        1. 197343, Санкт Петербург, ул. Торжковская, д. 15
        2. 420097, Казань, ул. Красная позиция, д. 6
        3. 125840, Москва, ул. Вилиса Лациса, д. 14
    """.trimIndent()
        assertDoesNotThrow {
            parseAddresses(address2)
        }
        val listAddresses2 = parseAddresses(address2)
        val listAddresses3: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        for (i in 0 .. 2) {
            assertEquals(listAddresses2[i].index, listAddresses3[i].index)
            assertEquals(listAddresses2[i].city, listAddresses3[i].city)
            assertEquals(listAddresses2[i].street, listAddresses3[i].street)
            assertEquals(listAddresses2[i].house, listAddresses3[i].house)
        }
    }

    @Test
    fun TestbiggestIndex() {
        val listAddresses1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            biggestIndex(listAddresses1)
        }

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = biggestIndex(listAddresses2)
        assertDoesNotThrow {
            biggestIndex(listAddresses2)
        }
        assertEquals(address2, listAddresses2.maxByOrNull { it.index })
    }

    @Test
    fun TestsmallestIndex() {
        val listAddresses1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            smallestIndex(listAddresses1)
        }

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = smallestIndex(listAddresses2)
        assertDoesNotThrow {
            smallestIndex(listAddresses2)
        }
        assertEquals(address2, listAddresses2.minByOrNull { it.index })
    }

    @Test
    fun TestlongestStreet() {
        val listAddresses1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            longestStreet(listAddresses1)
        }

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = longestStreet(listAddresses2)
        assertDoesNotThrow {
            longestStreet(listAddresses2)
        }
        assertEquals(address2, listAddresses2.maxByOrNull { it.street.length })
    }

    @Test
    fun TestshortestStreet() {
        val listAddresses1: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            shortestStreet(listAddresses1)
        }

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = shortestStreet(listAddresses2)
        assertDoesNotThrow {
            shortestStreet(listAddresses2)
        }
        assertEquals(address2, listAddresses2.minByOrNull { it.street.length })
    }
}