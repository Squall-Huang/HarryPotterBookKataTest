class Cart {

    val books = mutableListOf<Book>()
    val discountLookup = mapOf(1 to 1.0, 2 to 0.95)

    fun add(book: Book) {
        books.add(book)
    }

    fun totalPrice(): Int {

        val discount = discountLookup[books.count()] ?: 1.0
        return (books.sumOf { 100.toInt() } * discount).toInt()

    }

}
