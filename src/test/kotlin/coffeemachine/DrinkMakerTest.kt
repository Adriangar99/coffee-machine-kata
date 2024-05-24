package coffeemachine

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DrinkMakerTest {

    @Test
    fun `Given a DrinkMaker it should `() {
        val drinkMaker = DrinkMaker()
        assertThrows<Exception> {
            drinkMaker.invoke("")
        }
    }
}