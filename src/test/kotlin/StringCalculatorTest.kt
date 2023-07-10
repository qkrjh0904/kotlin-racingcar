import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    test("덧셈만 있는 문자열 식을 받아 계산할 수 있다.") {
        // given
        val expression = "1 + 2 + 3"

        // when
        val answer = calculate(expression)

        // then
        answer shouldBe 6
    }
})

fun calculate(expression: String): Int {
    val splitExpression = expression.split(" ")
    var answer = splitExpression[0].toInt()

    for (index in 1 until splitExpression.size step 2) {
        val operator = splitExpression[index]
        val number = splitExpression[index + 1].toInt()

        when (operator) {
            "+" -> answer = answer plus number
        }
    }

    return answer
}

infix fun Int.plus(other: Int): Int {
    return this.plus(other)
}
