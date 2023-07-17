package step3

enum class ErrorMessageType(
    val message: String
) {
    INPUT_SHOULD_BE_A_POSITIVE_NUMBER("입력값은 양수여야합니다."),
    INPUT_CANNOT_BE_EMPTY("입력값은 빈 값일 수 없습니다.")
}
