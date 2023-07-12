package step2.enums

enum class ErrorMessage(
    val message: String
) {
    EXPRESSION_CANNOT_BE_EMPTY("수식은 빈 값일 수 없습니다."),
    EXPRESSION_COUNT_SHOULD_BE_ODD("수식의 수는 홀수로 구성되어야 합니다."),
    NOT_A_NUMBER("숫자가 아닙니다."),
    NOT_A_OPERATOR("사칙연산이 아닙니다."),
    CANNOT_DIVIDE_BY_ZERO("0으로 나눌 수 없습니다.")
}
