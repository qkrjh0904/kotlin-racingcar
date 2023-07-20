package step3

import step3.objects.RacingCar
import step3.objects.RandomIntGenerator
import step3.view.InputView
import step3.view.OutputView
import step3.view.ViewMessage.OUTPUT_RESULT_MESSAGE

const val REFERENCE_VALUE = 4
fun main() {
    val racingCarNum = InputView.inputRacingCarNum()
    val tryNum = InputView.inputTryNum()

    val racingCarList = createRacingCarList(racingCarNum)

    startRace(racingCarList, tryNum)
}

fun startRace(racingCarList: List<RacingCar>, tryNum: Int) {
    println(OUTPUT_RESULT_MESSAGE.message)
    for (i in 1..tryNum) {
        moveCar(racingCarList)
        OutputView.print(racingCarList)
    }
}

fun moveCar(racingCarList: List<RacingCar>) {
    racingCarList.forEach { racingCar ->
        if (RandomIntGenerator.generate() >= REFERENCE_VALUE) {
            racingCar.move()
        }
    }
}

private fun createRacingCarList(racingCarNum: Int): List<RacingCar> {
    val racingCarList = mutableListOf<RacingCar>()

    for (i in 1..racingCarNum) {
        racingCarList.add(RacingCar.create())
    }

    return racingCarList
}
