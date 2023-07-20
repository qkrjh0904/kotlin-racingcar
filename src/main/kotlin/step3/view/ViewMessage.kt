package step3.view

enum class ViewMessage(
    val message: String
) {
    INPUT_RACING_CAR_NUM_MESSAGE("자동차 대수는 몇 대인가요?"),
    INPUT_TRY_NUM_MESSAGE("시도할 횟수는 몇 회인가요?"),
    OUTPUT_RESULT_MESSAGE("실행 결과")
}
