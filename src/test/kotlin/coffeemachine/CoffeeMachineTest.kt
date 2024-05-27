package coffeemachine

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class CoffeeMachineTest {

    private val drinkMaker = mockk<DrinkMaker>(relaxed = true)

    @Test
    fun `Given a CoffeeMachine when coffee is selected it should print coffee`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.COFFEE)
        coffeeMachine.makeDrink()

        verify(exactly = 1) {
            drinkMaker.invoke("C::")
        }
    }

    @ParameterizedTest
    @EnumSource(DrinkType::class)
    fun `Given a drink it should invoke the correct command`(drinkType: DrinkType) {
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.select(drinkType)
        coffeeMachine.makeDrink()
        verify(exactly = 1) {
            drinkMaker.invoke("${drinkType.value}::")
        }
    }

    @Test
    fun `Given a CoffeeMachine when coffee is selected and sugar is added it should print coffee and sugar`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.COFFEE)
        coffeeMachine.addSugar()
        coffeeMachine.makeDrink()

        verify(exactly = 1) {
            drinkMaker.invoke("C:1:0")
        }
    }

    @Test
    fun `Given a CoffeeMachine when tea is selected it should print tea`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.TEA)
        coffeeMachine.makeDrink()

        verify(exactly = 1) {
            drinkMaker.invoke("T::")
        }
    }

    @Test
    fun `Given a CoffeeMachine when chocolate is selected it should print chocolate`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.CHOCOLATE)
        coffeeMachine.makeDrink()

        verify(exactly = 1) {
            drinkMaker.invoke("H::")
        }
    }

    @Test
    fun `Given a CoffeeMachine when select coffee it should save it`() {
        val coffeeMachine = CoffeeMachine(drinkMaker)

        coffeeMachine.select(DrinkType.COFFEE)

        assertThat(coffeeMachine.drinkType).isEqualTo(DrinkType.COFFEE)
    }
}