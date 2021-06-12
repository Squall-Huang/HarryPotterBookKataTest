class Cart {

    val books = mutableListOf<Book>()
    val discountLookup = mapOf(1 to 1.0, 2 to 0.95, 3 to 0.9, 4 to 0.8, 5 to 0.75)

    fun add(book: Book) {
        books.add(book)
    }

    fun totalPrice(): Int {

        val unCheckoutBooks = books.toTypedArray().clone().toMutableList()
        val booksSet = mutableListOf<BooksSet>()

        while (unCheckoutBooks.any()) {
            val booksForSet = mutableListOf<Book>()
            for (item in ArrayList(unCheckoutBooks)) {
                val findBookCount = booksForSet.filter { it.isbn == item.isbn }.count()
                if (findBookCount == 0) {
                    booksForSet.add(item)
                    unCheckoutBooks.remove(item)
                }
            }
            val discount = discountLookup[booksForSet.count()] ?: 1.0
            val oneSet = BooksSet(booksForSet, discount)
            booksSet.add(oneSet)
        }

        var totalPrice = 0
        booksSet.forEach{
            totalPrice += (it.books.sumOf { 100.toInt() } * it.discount).toInt()
        }

        return totalPrice



    }

}
