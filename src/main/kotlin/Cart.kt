class Cart {

    var books = mutableListOf<Book>()

    fun add(book: Book) {
        books.add(book)
    }

    fun totalPrice(): Int {
        if (books.count() == 2) {
            return (books.sumOf { 100.toInt() } * 0.95).toInt()

        }
        return books.sumOf { 100.toInt() }
    }

}
