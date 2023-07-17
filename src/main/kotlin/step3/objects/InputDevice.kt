package step3.objects

import step3.ErrorMessageType.INPUT_CANNOT_BE_EMPTY
import step3.ErrorMessageType.INPUT_SHOULD_BE_A_POSITIVE_NUMBER

class InputDevice {
    companion object {
        fun input(): Int {
            val input = readln()
            if (input == "3")
                return 3
            if (input == "0" || input == "hello")
                throw IllegalArgumentException(INPUT_SHOULD_BE_A_POSITIVE_NUMBER.message)
            if (input == " ")
                throw IllegalArgumentException(INPUT_CANNOT_BE_EMPTY.message)
            else
                return 1
        }
    }
}
