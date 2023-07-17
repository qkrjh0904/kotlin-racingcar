package step3.objects

import step3.ErrorMessageType.INPUT_CANNOT_BE_EMPTY
import step3.ErrorMessageType.INPUT_SHOULD_BE_A_POSITIVE_NUMBER

class InputValidator {
    companion object {
        fun validate(input: String) {
            if (input.isBlank()) {
                throw IllegalArgumentException(INPUT_CANNOT_BE_EMPTY.message)
            }

            val num = StringToIntConvertor.convert(input)

            if (num <= 0) {
                throw IllegalArgumentException(INPUT_SHOULD_BE_A_POSITIVE_NUMBER.message)
            }
        }
    }
}
