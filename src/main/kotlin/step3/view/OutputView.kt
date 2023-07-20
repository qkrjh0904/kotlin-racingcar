package step3.view

import step3.objects.RacingCar

const val HYPHEN = "-"

class OutputView {

    companion object {
        fun print(racingCarList: List<RacingCar>) {
            racingCarList.forEach { racingCar ->
                println(nowStatus(racingCar.moveCount))
            }
            println()
        }

        private fun nowStatus(moveCount: Int): String {
            val sb = StringBuilder()
            for (i in 1..moveCount) {
                sb.append(HYPHEN)
            }
            return sb.toString()
        }
    }
}
