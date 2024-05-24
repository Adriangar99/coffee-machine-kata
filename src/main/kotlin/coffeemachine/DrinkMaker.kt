package coffeemachine

class DrinkMaker {
    operator fun invoke(command: String) {
        throw Exception("Invalid command")
    }
}