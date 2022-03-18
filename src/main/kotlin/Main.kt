fun main() {
    val addresses = """
        1. 197343, Санкт Петербург, ул. Торжковская, д. 15
        2. 420097, Казань, ул. Красная позиция, д. 6
        3. 125840, Москва, ул. Вилиса Лациса, д. 14
    """.trimIndent()

    val list_addresses: List<Address>

    list_addresses = parseAddresses(addresses)

    println("List of addresses:")
    for (address in list_addresses) {
        println(address)
    }

    println("Address with the biggest index: ${biggest_index(list_addresses)}")
    println("Address with the smallest index: ${smallest_index(list_addresses)}")
    println("Address with the longest street: ${longest_street(list_addresses)}")
    println("Address with the shortest street: ${shortest_street(list_addresses)}")
}