package objects

import enums.Operator.DIV
import enums.Operator.MINUS
import enums.Operator.PLUS
import enums.Operator.TIMES

class StringCalculator(
    private val expression: String?
) {

    init {
        require(!expression.isNullOrBlank()) {
            "수식은 빈 값일 수 없습니다."
        }
    }

    fun calculate(): Int {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("입력값을 다시 확인해주세요.")
        }

        val splitExpression = expression.split(" ")
        var answer = splitExpression[0].toInt()

        for (index in 1 until splitExpression.size step 2) {
            val operator = splitExpression[index].trim()
            val number = splitExpression[index + 1].toInt()

            answer = when (operator) {
                PLUS.operator -> answer plus number
                MINUS.operator -> answer minus number
                TIMES.operator -> answer times number
                DIV.operator -> answer div number
                else -> throw IllegalArgumentException("$operator 는 사칙 연산 기호(+, -, *, /)가 아닙니다.")
            }
        }

        return answer
    }

    infix fun Int.plus(other: Int) = this.plus(other)

    infix fun Int.minus(other: Int) = this.minus(other)

    infix fun Int.times(other: Int) = this.times(other)

    infix fun Int.div(other: Int): Int {
        require(other != 0) { "0으로 나눌 수 없습니다." }
        return this.div(other)
    }
}
