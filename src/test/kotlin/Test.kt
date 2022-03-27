import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AddressKtTest {
    @Test
    fun testParseAddress() {
        val address1 = ""
        assertSame(parseAddresses(address1), emptyList<Address>())

        val address2 = """
        1. 197343, Санкт Петербург, ул. Торжковская, д. 15
        2. 420097, Казань, ул. Красная позиция, д. 6
        3. 125840, Москва, ул. Вилиса Лациса, д. 14
    """.trimIndent()

        assertNotSame(parseAddresses(address2), emptyList<Address>())
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
    fun testBiggestIndex() {
        val listAddresses1: List<Address> = emptyList()
        assertNull(biggestIndex(listAddresses1))

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = biggestIndex(listAddresses2)
        assertNotNull(biggestIndex(listAddresses2))
        assertEquals(address2, listAddresses2.maxByOrNull { it.index })
    }

    @Test
    fun testSmallestIndex() {
        val listAddresses1: List<Address> = emptyList()
        assertNull(smallestIndex(listAddresses1))

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = smallestIndex(listAddresses2)
        assertNotNull(smallestIndex(listAddresses2))
        assertEquals(address2, listAddresses2.minByOrNull { it.index })
    }

    @Test
    fun testLongestStreet() {
        val listAddresses1: List<Address> = emptyList()
        assertNull(longestStreet(listAddresses1))

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = longestStreet(listAddresses2)
        assertNotNull(longestStreet(listAddresses2))
        assertEquals(address2, listAddresses2.maxByOrNull { it.street.length })
    }

    @Test
    fun testShortestStreet() {
        val listAddresses1: List<Address> = emptyList()
        assertNull(shortestStreet(listAddresses1))

        val listAddresses2: List<Address> = listOf(
            Address(197343, "Санкт Петербург", "Торжковская", 15),
            Address(420097, "Казань", "Красная позиция", 6),
            Address(125840, "Москва", "Вилиса Лациса", 14)
        )
        val address2 = shortestStreet(listAddresses2)
        assertNotNull(shortestStreet(listAddresses2))
        assertEquals(address2, listAddresses2.minByOrNull { it.street.length })
    }
}