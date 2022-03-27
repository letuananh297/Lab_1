fun main() {
    val addresses = """
        1. 197343, Санкт Петербург, ул. Торжковская, д. 15
        2. 420097, Казань, ул. Красная позиция, д. 6
        3. 125840, Москва, ул. Вилиса Лациса, д. 14
    """.trimIndent()

    val listAddresses: List<Address>

    listAddresses = parseAddresses(addresses)

    println("List of addresses:")
    for (address in listAddresses) {
        println(address)
    }

    println("Address with the biggest index: ${biggestIndex(listAddresses)}")
    println("Address with the smallest index: ${smallestIndex(listAddresses)}")
    println("Address with the longest street: ${longestStreet(listAddresses)}")
    println("Address with the shortest street: ${shortestStreet(listAddresses)}")
}