import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import step3.objects.InputDevice
import java.io.ByteArrayInputStream

class CarRacingInputTest : BehaviorSpec({

    Given("정상적인 자동차 대수를 입력 한다.") {
        val mockInput = "3"
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        When("입력을 받고 유효성 체크를 한다.") {
            val racingCarNum = InputDevice.input()

            Then("정상 출력 된다.") {
                println(racingCarNum)
            }
        }
    }

    Given("정상적인 자동차 대수를 입력 하고, 시도 횟수에 0 이하의 숫자를 넣는다.") {
        val mockInput = "1"
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        val mockInput2 = "-1"
        val inputStream2 = ByteArrayInputStream(mockInput2.toByteArray())
        System.setIn(inputStream2)

        When("입력을 받고 유효성 체크를 한다.") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    val racingCarNum = InputDevice.input()
                    println(racingCarNum)
                    InputDevice.input()
                }
            }
        }
    }

    Given("정상적인 자동차 대수를 입력 하고, 시도 횟수에 숫자가 아닌 문자열을 넣는다.") {
        val mockInput = "10"
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        val mockInput2 = "a"
        val inputStream2 = ByteArrayInputStream(mockInput2.toByteArray())
        System.setIn(inputStream2)

        When("입력을 받고 유효성 체크를 한다.") {
            Then("NumberFormatException 이 발생한다.") {
                shouldThrowExactly<NumberFormatException> {
                    val racingCarNum = InputDevice.input()
                    println(racingCarNum)
                    InputDevice.input()
                }
            }
        }
    }

    Given("정상적인 자동차 대수를 입력 하고, 빈 문자열을 넣는다.") {
        val mockInput = "3"
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        val mockInput2 = "    "
        val inputStream2 = ByteArrayInputStream(mockInput2.toByteArray())
        System.setIn(inputStream2)

        When("입력을 받고 유효성 체크를 한다.") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    val racingCarNum = InputDevice.input()
                    println(racingCarNum)
                    InputDevice.input()
                }
            }
        }
    }

    Given("0 이하의 숫자를 넣는다.") {
        val mockInput = "0"
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        When("입력을 받고 유효성 체크를 한다.") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    InputDevice.input()
                }
            }
        }
    }

    Given("숫자가 아닌 문자열을 넣는다.") {
        val mockInput = "hello"
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        When("입력을 받고 유효성 체크를 한다.") {
            Then("NumberFormatException 이 발생한다.") {
                shouldThrowExactly<NumberFormatException> {
                    InputDevice.input()
                }
            }
        }
    }

    Given("빈 값을 넣는다.") {
        val mockInput = " "
        val inputStream = ByteArrayInputStream(mockInput.toByteArray())
        System.setIn(inputStream)

        When("입력을 받고 유효성 체크를 한다.") {
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    InputDevice.input()
                }
            }
        }
    }
})
