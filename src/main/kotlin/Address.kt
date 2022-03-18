data class Address (val index: Int, val city: String, val street: String, val house: Int) {
    override fun toString(): String {
        return "$index, $city, ул. $street, д. $house"
    }
}

fun parseAddresses(addresses: String) : MutableList<Address> {
    if (addresses.isEmpty()) {
        throw IllegalArgumentException("String is empty.")
    }

    val list_addresses = mutableListOf<Address>()
    val strings = addresses.split('\n')

    for (str in strings) {
        val parts = str.split(',') //N. ИндексN, Название города N, ул. Название улицы, д. Номер дома
        val index = parts[0].drop(3).toInt()
        val city = parts[1].drop(1)
        val street = parts[2].drop(5)
        val house = parts[3].drop(4).toInt()
        val address = Address(index, city, street, house)
        list_addresses.add(address)
    }
    return list_addresses
}

fun biggest_index(list_addresses: List<Address>) : Address {
    if (list_addresses.isEmpty()) {
        throw IllegalArgumentException("List of addresses is empty.")

    }
    var address = list_addresses[0]
    for (temp in list_addresses) {
        if (address.index < temp.index) {
            address = temp
        }
    }
    return address
}

fun smallest_index(list_addresses: List<Address>) : Address {
    if (list_addresses.isEmpty()) {
        throw IllegalArgumentException("List of addresses is empty.")
    }
    var address = list_addresses[0]
    for (temp in list_addresses) {
        if (address.index > temp.index) {
            address = temp
        }
    }
    return address
}

fun longest_street(list_addresses: List<Address>) : Address {
    if (list_addresses.isEmpty()) {
        throw IllegalArgumentException("List of addresses is empty.")
    }
    var address = list_addresses[0]
    for (temp in list_addresses) {
        if (address.street.length < temp.street.length) {
            address = temp
        }
    }
    return address
}

fun shortest_street(list_addresses: List<Address>) : Address {
    if (list_addresses.isEmpty()) {
        throw IllegalArgumentException("List of addresses is empty.")
    }
    var address = list_addresses[0]
    for (temp in list_addresses) {
        if (address.street.length > temp.street.length) {
            address = temp
        }
    }
    return address
}