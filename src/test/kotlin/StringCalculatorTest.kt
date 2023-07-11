import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import objects.StringCalculator

class StringCalculatorTest : BehaviorSpec({

    Given("덧셈을 할 수 있다.") {
        val expression = "1 + 2"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe 3
            }
        }
    }

    Given("뺄셈을 할 수 있다.") {
        val expression = "2 - 3"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe -1
            }
        }
    }

    Given("곱셈을 할 수 있다.") {
        val expression = "2 * 0 * 3"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe 0
            }
        }
    }

    Given("나눗셈을 할 수 있다.") {
        val expression = "15 / 2"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe 7
            }
        }
    }

    Given("0으로 나누면 IllegalArgumentException 을 throw 한다.") {
        val expression = "15 / 0"

        When("계산기를 생성 하면") {
            Then("IllegalArgumentException 을 throw 한다.") {
                shouldThrowWithMessage<IllegalArgumentException>("0으로 나눌 수 없습니다.") {
                    val calculator = StringCalculator(expression)
                    calculator.calculate()
                }
            }
        }
    }

    Given("다양한 연산자가 있는 문자열을 계산할 수 있다.") {
        val expression = "2 + 3 * 4 / 2"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe 10
            }
        }
    }

    Given("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 을 던진다.") {
        val expression1 = " "
        val expression2 = null

        When("계산기를 생성하면") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator(expression1)
                }

                shouldThrowExactly<IllegalArgumentException> {
                    StringCalculator(expression2)
                }
            }
        }
    }

    Given("입력값에 사칙연산 기호가 아닌 값이 들어가는 경우 IllegalArgumentException 을 던진다.") {
        val expression = "1 ^ 2"

        When("계산을 하면") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    val calculator = StringCalculator(expression)
                    calculator.calculate()
                }
            }
        }
    }
})
