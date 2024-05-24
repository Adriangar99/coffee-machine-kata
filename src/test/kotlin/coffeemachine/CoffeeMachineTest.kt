package coffeemachine

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class CoffeeMachineTest {

    private val drinkMaker: DrinkMaker = mock()

    @Test
    fun `Given a CoffeeMachine when coffee is selected it should print coffee`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.selectCoffee()
        coffeeMachine.makeDrink()

        verify(1) {
            drinkMaker.invoke("C::")
        }

    }
}