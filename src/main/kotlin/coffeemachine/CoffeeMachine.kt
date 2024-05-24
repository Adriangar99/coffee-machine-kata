package coffeemachine

enum class DrinkType(val value: String) {
    COFFEE("C"),
    TEA("T"),
    CHOCOLATE("H")
}

open class CoffeeMachine(private val drinkMaker: DrinkMaker) {
    lateinit var drinkType: DrinkType
        private set

    var sugarQuantity: Int = 0
        private set

    fun select(selectedDrink: DrinkType) {
        drinkType = selectedDrink
    }

    fun addSugar() {
        sugarQuantity += 1
    }

    fun makeDrink() {
        drinkMaker.invoke(buildCommand())
    }

    private fun buildCommand(): String {
        return "${drinkType.value}::"
    }
}