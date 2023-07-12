package step2.enums

enum class Operator(
    val operator: String
) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    companion object {

        private val operatorMap = values().associateBy { it.operator }
        fun of(operator: String): Operator = operatorMap.getOrElse(operator) {
            throw IllegalArgumentException("${ErrorMessage.NOT_A_OPERATOR.message} operator=$operator")
        }
    }
}
