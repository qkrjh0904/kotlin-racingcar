package step3.objects

const val START_MOVE_COUNT = 0

class RacingCar(
    var moveCount: Int
) {

    fun move() {
        moveCount++
    }

    companion object {
        fun create(): RacingCar = RacingCar(START_MOVE_COUNT)
    }
}
