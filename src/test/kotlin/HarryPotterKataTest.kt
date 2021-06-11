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
    fun buy_1_normal_price() {
        buyBook("1")
        priceShouldBe(100)
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