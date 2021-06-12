import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HarryPotterKataTest {

    private lateinit var cart: Cart

    @BeforeEach
    fun setup() {
        cart = Cart()
    }

    @Test
    fun `buy 1 normal price`() {
        buyBook("1")
        priceShouldBe(100)
    }

    @Test
    fun `buy 2 different copies 5 percent discount`() {
        buyBook("1","2")
        priceShouldBe(190)
    }

    @Test
    fun `buy 3 different copies 10 percent discount`() {
        buyBook("1","2","3")
        priceShouldBe(270)
    }

    private fun priceShouldBe(expectedPrice: Int) {
        assertEquals(expectedPrice, cart.totalPrice())
    }

    private fun buyBook(vararg isbn: String) {
        isbn.forEach {
            val book = Book(it)
            cart.add(book)
        }
    }
}