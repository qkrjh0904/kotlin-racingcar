package step3.objects

import step3.enums.ErrorMessageType

class StringToIntConvertor {
    companion object {
        fun convert(input: String): Int {
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                throw NumberFormatException(ErrorMessageType.INPUT_SHOULD_BE_A_POSITIVE_NUMBER.message)
            }
        }
    }
}
