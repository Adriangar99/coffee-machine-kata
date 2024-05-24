package coffeemachine

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify

class CoffeeMachineTest {

    private val drinkMaker = mock<DrinkMaker>()

    @Test
    fun `Given a CoffeeMachine when coffee is selected it should print coffee`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.COFFEE)
        coffeeMachine.makeDrink()

        verify(drinkMaker).invoke("C::")
    }

    @Test
    fun `Given a CoffeeMachine when coffee is selected and sugar is added it should print coffee and sugar`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.COFFEE)
        coffeeMachine.addSugar()
        coffeeMachine.makeDrink()

        verify(drinkMaker).invoke("C:1:0")
    }

    @Test
    fun `Given a CoffeeMachine when tea is selected it should print tea`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.TEA)
        coffeeMachine.makeDrink()

        verify(drinkMaker).invoke("T::")
    }

    @Test
    fun `Given a CoffeeMachine when chocolate is selected it should print chocolate`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.CHOCOLATE)
        coffeeMachine.makeDrink()

        verify(drinkMaker).invoke("H::")
    }

    @Test
    fun `Given a CoffeeMachine when select coffee it should save it`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.COFFEE)

        assertThat(coffeeMachine.drinkType).isEqualTo(DrinkType.COFFEE)
    }
}