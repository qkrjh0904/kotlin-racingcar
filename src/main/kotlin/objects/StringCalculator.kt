package objects

import enums.ErrorMessage.CANNOT_DIVIDE_BY_ZERO
import enums.ErrorMessage.EXPRESSION_CANNOT_BE_EMPTY
import enums.ErrorMessage.EXPRESSION_COUNT_SHOULD_BE_ODD
import enums.ErrorMessage.NOT_A_NUMBER
import enums.ErrorMessage.NOT_A_OPERATOR
import enums.Operator.DIV
import enums.Operator.MINUS
import enums.Operator.PLUS
import enums.Operator.TIMES

private const val ZERO = 0

class StringCalculator(
    private val expression: String?
) {

    companion object {
        private const val DELIMITER_SPACE = " "
        private const val TWO = 2
        private const val ONE = 1
    }

    init {
        require(!expression.isNullOrBlank()) {
            EXPRESSION_CANNOT_BE_EMPTY.message
        }
    }

    fun calculate(): Int {
        val splitExpression = expression!!.split(DELIMITER_SPACE)
        splitExpression.map { it.trim() }
        println(splitExpression)

        require(splitExpression.size % TWO == ONE) {
            EXPRESSION_COUNT_SHOULD_BE_ODD.message
        }

        val queue = ArrayDeque(splitExpression)
        var answer = toNumber(queue.removeFirst())
        while (queue.isNotEmpty()) {
            val operator = queue.removeFirst()
            val number = toNumber(queue.removeFirst())

            answer = when (operator) {
                PLUS.operator -> answer.plus(number)
                MINUS.operator -> answer.minus(number)
                TIMES.operator -> answer.times(number)
                DIV.operator -> answer.checkAndDiv(number)
                else -> throw IllegalArgumentException("${NOT_A_OPERATOR.message} operator=$operator")
            }
        }

        return answer
    }

    private fun toNumber(number: String): Int {
        try {
            return number.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("${NOT_A_NUMBER.message} number=$number")
        }
    }

    private fun Int.checkAndDiv(other: Int): Int {
        require(other != ZERO) { CANNOT_DIVIDE_BY_ZERO.message }
        return this.div(other)
    }
}
