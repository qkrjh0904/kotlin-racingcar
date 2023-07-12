package step2.objects

import step2.enums.ErrorMessage.CANNOT_DIVIDE_BY_ZERO
import step2.enums.ErrorMessage.EXPRESSION_CANNOT_BE_EMPTY
import step2.enums.ErrorMessage.EXPRESSION_COUNT_SHOULD_BE_ODD
import step2.enums.ErrorMessage.NOT_A_NUMBER
import step2.enums.Operator
import step2.enums.Operator.DIV
import step2.enums.Operator.MINUS
import step2.enums.Operator.PLUS
import step2.enums.Operator.TIMES

private const val ZERO = 0.0

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

    fun calculate(): Double {
        val splitExpression = splitExpression(expression!!)
        val queue = ArrayDeque(splitExpression)

        var answer = toNumber(queue.removeFirst())
        while (queue.isNotEmpty()) {
            val operator = Operator.of(queue.removeFirst())
            val number = toNumber(queue.removeFirst())

            answer = when (operator) {
                PLUS -> answer.plus(number)
                MINUS -> answer.minus(number)
                TIMES -> answer.times(number)
                DIV -> answer.checkAndDiv(number)
            }
        }

        return answer
    }

    private fun splitExpression(expression: String): List<String> {
        val splitExpression = expression.split(DELIMITER_SPACE).map { it.trim() }

        require(splitExpression.size % TWO == ONE) {
            EXPRESSION_COUNT_SHOULD_BE_ODD.message
        }

        return splitExpression
    }

    private fun toNumber(number: String): Double {
        try {
            return number.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("${NOT_A_NUMBER.message} number=$number")
        }
    }

    private fun Double.checkAndDiv(other: Double): Double {
        require(other != ZERO) { CANNOT_DIVIDE_BY_ZERO.message }
        return this.div(other)
    }
}
