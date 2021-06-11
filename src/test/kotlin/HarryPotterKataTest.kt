import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HarryPotterKataTest {

    @Test
    fun buy_1_normal_price() {
        val cart = Cart()
        val book = Book("1")
        cart.add(book)
        assertEquals(100,cart.totalPrice())
    }
}