import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : BehaviorSpec({

    Given("덧셈만 있는 문자열이 주어진다.") {
        val expression = "1 + 2 + 3"

        When("계산을 하면") {
            val answer = calculate(expression)

            Then("6이 니온다.") {
                answer shouldBe 6
            }
        }
    }

    Given("뺄셈만 있는 문자열이 주어진다.") {
        val expression = "2 - 3 - 1"

        When("계산을 하면") {
            val answer = calculate(expression)

            Then("결과값이 니온다.") {
                answer shouldBe -2
            }
        }
    }

    Given("곱셈만 있는 문자열이 주어진다.") {
        val expression = "1 * 2 * 3 * -4"

        When("계산을 하면") {
            val answer = calculate(expression)

            Then("결과값이 니온다.") {
                answer shouldBe -24
            }
        }
    }

    Given("나눗셈만 있는 문자열이 주어진다.") {
        val expression = "15 / 2 / -3"

        When("계산을 하면") {
            val answer = calculate(expression)

            Then("결과값이 니온다.") {
                answer shouldBe -2
            }
        }
    }

    Given("모든 연산자가 포함되어 있는 문자열이 주어진다.") {
        val expression = "2 + 3 * 4 / 2"

        When("계산을 하면") {
            val answer = calculate(expression)

            Then("결과값이 니온다.") {
                answer shouldBe 10
            }
        }
    }

    Given("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 을 던진다.") {
        val expression1 = "    "
        val expression2 = null

        When("계산을 하면") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowWithMessage<IllegalArgumentException>("입력값을 다시 확인해주세요.") {
                    calculate(expression1)
                }

                shouldThrowWithMessage<IllegalArgumentException>("입력값을 다시 확인해주세요.") {
                    calculate(expression2)
                }
            }
        }
    }
})

fun calculate(expression: String?): Int {
    if (expression.isNullOrBlank()) {
        throw IllegalArgumentException("입력값을 다시 확인해주세요.")
    }

    val splitExpression = expression.split(" ")
    var answer = splitExpression[0].toInt()

    for (index in 1 until splitExpression.size step 2) {
        val operator = splitExpression[index].trim()
        val number = splitExpression[index + 1].toInt()

        when (operator) {
            "+" -> answer = answer plus number
            "-" -> answer = answer minus number
            "*" -> answer = answer times number
            "/" -> answer = answer div number
        }
    }

    return answer
}

infix fun Int.plus(other: Int): Int {
    return this.plus(other)
}

infix fun Int.minus(other: Int): Int {
    return this.minus(other)
}

infix fun Int.times(other: Int): Int {
    return this.times(other)
}

infix fun Int.div(other: Int): Int {
    return this.div(other)
}
