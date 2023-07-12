import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step2.objects.StringCalculator

class StringCalculatorTest : BehaviorSpec({

    Given("덧셈을 할 수 있다.") {
        val expression = "1.2 + 2.12"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe (1.2 + 2.12)
            }
        }
    }

    Given("뺄셈을 할 수 있다.") {
        val expression = "2 - 3.7"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe (2 - 3.7)
            }
        }
    }

    Given("곱셈을 할 수 있다.") {
        val expression = "2 * 0 * 3.2"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe (2 * 0 * 3.2)
            }
        }
    }

    Given("나눗셈을 할 수 있다.") {
        val expression = "15.2 / 2.1"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe (15.2 / 2.1)
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
        val expression = "2.3 + 3.7 * 4 / 2"

        When("계산을 하면") {
            val calculator = StringCalculator(expression)
            val answer = calculator.calculate()

            Then("결과값이 니온다.") {
                answer shouldBe 12
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

    Given("비정상적인 수식이 주어지면 IllegalArgumentException 을 던진다.") {
        val expression = "****"
        val expression2 = "1 3"
        val expression3 = "1 3 4"

        When("계산을 하면") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    val calculator = StringCalculator(expression)
                    calculator.calculate()
                }

                shouldThrowExactly<IllegalArgumentException> {
                    val calculator = StringCalculator(expression2)
                    calculator.calculate()
                }

                shouldThrowExactly<IllegalArgumentException> {
                    val calculator = StringCalculator(expression3)
                    calculator.calculate()
                }
            }
        }
    }
})
