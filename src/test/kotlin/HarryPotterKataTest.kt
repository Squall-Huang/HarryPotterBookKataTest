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
        buyBook("1", "2")
        priceShouldBe(190)
    }

    @Test
    fun `buy 3 different copies 10 percent discount`() {
        buyBook("1", "2", "3")
        priceShouldBe(270)
    }

    @Test
    fun `buy 4 different copies 20 percent discount`() {
        buyBook("1", "2", "3", "4")
        priceShouldBe(320)
    }

    @Test
    fun `buy 5 different copies 25 percent discount`() {
        buyBook("1", "2", "3", "4", "5")
        priceShouldBe(375)
    }

    @Test
    fun `buy 4 copies 3 different`() {
        buyBook("1", "1", "2", "3")
        //1,2,3=>300*0.9=270
        //1=>100
        priceShouldBe(370)
    }

    @Test
    fun `best discount`() {
        buyBook("1", "1", "2", "2", "3", "3", "4", "5")
        //1,2,3,4=>400*0.8
        //1,2,3,5=>400*0.8
        priceShouldBe(640)
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